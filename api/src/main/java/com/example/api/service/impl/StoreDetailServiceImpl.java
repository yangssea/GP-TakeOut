package com.example.api.service.impl;

import com.example.api.entity.Coupons;
import com.example.api.entity.Goods;
import com.example.api.entity.StoreDetail;
import com.example.api.entity.dto.StoreDto;
import com.example.api.entity.impl.*;
import com.example.api.service.StoreDetailService;
import com.example.api.util.GetDistanceMeter;
import com.example.api.util.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * @author yzx
 * @date 2020/4/2  20:23
 */
@Service
public class StoreDetailServiceImpl implements StoreDetailService {
    @Autowired
    private StoreDetailImpl storeDetailImpl;
    @Autowired
    private GradeImpl gradeImpl;
    @Autowired
    private OrdersImpl orderImpl;
    @Autowired
    private CouponsImpl couponsImpl;
    @Autowired
    private GoodsImpl goodsImpl;
    //为首页商店展示做筛选
    @Override
    public Object getStoreList(int page, int type, double lat, double lng) {
        //商店类型选择
        List<StoreDetail> list = new ArrayList<>();
        List<StoreDetail> listNew = new ArrayList<>();
        List<StoreDto> list1 = new ArrayList<>();
        if (type == 0) {
            list = storeDetailImpl.findStoreAll();
        } else if (type < 0 || type > 5) {
            return "类型错误";
        } else {
            list = storeDetailImpl.findType(type);
        }
        //筛选地址
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            double menter;
            if (list.get(i).getLatitude() == null || list.get(i).getLatitude().equals("") || list.get(i).getLongitude().equals("") || list.get(i).getLongitude().equals("")) {
                menter = 0.0;
            } else {
                menter = GetDistanceMeter.getMeter(lat, lng, Double.parseDouble(list.get(i).getLatitude()), Double.parseDouble(list.get(i).getLongitude()));
            }
            //如果小于15000米则选为附近店铺
            if (menter < 15000) {
                listNew.add(list.get(i));
            }
        }
        //page从1开始
        //筛选type
        list = listNew;
        if (list == null && list.size() < 10) {
            return list;
        } else {
            //将list数据写进list1
            for (int i = 0; i < list.size(); i++) {
                if (i >= (page - 1) * 10 && i < page * 10) {
                    StoreDto storeDto = new StoreDto();
                    storeDto.setStoreDetail(list.get(i));
                    //经纬度获取

                    //获取商店评分
                    String o = gradeImpl.find(list.get(i).getId());
                    if (o == null || o.equals("") || (o.split(",")[0].substring(0, 1).equals("n"))) {
                        storeDto.setGrade("0");
                    } else {
                        double grade = (Double.valueOf(o.split(",")[0]) + Double.valueOf(o.split(",")[1]) + Double.valueOf(o.split(",")[2])) / 3.0;
                        storeDto.setGrade(String.format("%.1f", grade));
                    }
                    //获取当前年月份
                    Calendar cale = null;
                    cale = Calendar.getInstance();
                    int year = cale.get(Calendar.YEAR);
                    int month = cale.get(Calendar.MONTH) + 1;
                    String like = "";
                    if (month < 10) {
                        like = "0" + month;
                    } else {
                        like += month;
                    }
                    //获取订单数
                    String orders = orderImpl.selectBySum(list.get(i).getId(), "%" + year + "-" + like + "%");
                    storeDto.setOrderSum(Integer.parseInt(orders));
                    //获取优惠列表
                    List<Coupons> liatCou = couponsImpl.getByStoreId(list.get(i).getId());
                    storeDto.setList(liatCou);
                    list1.add(storeDto);
                }
            }
            return list1;
        }
    }

    //搜索商店的详细z展示
    @Override
    public Object findStoreList(int page, int type, double lat, double lng, String find) {
        List<StoreDetail> list = storeDetailImpl.findLike("%"+find+"%");
        List<StoreDetail> listNew = new ArrayList<>();
        List<StoreDto> list1 = new ArrayList<>();
        //筛选地址
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            double menter;
            if (list.get(i).getLatitude() == null || list.get(i).getLatitude().equals("") || list.get(i).getLongitude().equals("") || list.get(i).getLongitude().equals("")) {
                menter = 0.0;
            } else {
                menter = GetDistanceMeter.getMeter(lat, lng, Double.parseDouble(list.get(i).getLatitude()), Double.parseDouble(list.get(i).getLongitude()));
            }
            //如果距离小于15000米则选为附近店铺
            if (menter < 15000) {
                listNew.add(list.get(i));
            }
        }
        list = listNew;
        //数据写进dto
        if (list == null && list.size() < 10) {
            return list;
        } else {
            //将list数据写进list1
            for (int i = 0; i < list.size(); i++) {
                StoreDto storeDto = new StoreDto();
                storeDto.setStoreDetail(list.get(i));
                //获取商店评分
                String o = gradeImpl.find(list.get(i).getId());
                if (o == null || o.equals("") || (o.split(",")[0].substring(0, 1).equals("n"))) {
                    storeDto.setGrade("0");
                } else {
                    double grade = (Double.valueOf(o.split(",")[0]) + Double.valueOf(o.split(",")[1]) + Double.valueOf(o.split(",")[2])) / 3.0;
                    storeDto.setGrade(String.format("%.1f", grade));
                }
                //获取当前年月份
                Calendar cale = null;
                cale = Calendar.getInstance();
                int year = cale.get(Calendar.YEAR);
                int month = cale.get(Calendar.MONTH) + 1;
                String like = "";
                if (month < 10) {
                    like = "0" + month;
                } else {
                    like += month;
                }
                //获取订单数
                String orders = orderImpl.selectBySum(list.get(i).getId(), "%" + year + "-" + like + "%");
                storeDto.setOrderSum(Integer.parseInt(orders));
                //获取优惠列表
                List<Coupons> liatCou = couponsImpl.getByStoreId(list.get(i).getId());
                storeDto.setList(liatCou);
                //获取商品列表（limit 3）
                List<Goods> listGoods = goodsImpl.findByStoreId(list.get(i).getId());
                if(listGoods==null||listGoods.size()<3){
                    storeDto.setGList(listGoods);
                }else{
                    List<Goods> listGoodsNew=new ArrayList<>();
                    for(int k=0;k<3;k++){
                        listGoodsNew.add(listGoods.get(k));
                    }
                    storeDto.setGList(listGoodsNew);
                }
                storeDto.setAllSort(Double.parseDouble(storeDto.getGrade())+storeDto.getOrderSum()*1.0);
                //获取距离
                double menter;
                if (list.get(i).getLatitude() == null || list.get(i).getLatitude().equals("") || list.get(i).getLongitude().equals("") || list.get(i).getLongitude().equals("")) {
                    menter = 0.0;
                } else {
                    menter = GetDistanceMeter.getMeter(lat, lng, Double.parseDouble(list.get(i).getLatitude()), Double.parseDouble(list.get(i).getLongitude()));
                }
                menter=Double.parseDouble(String.format("%.1f", menter));
                storeDto.setDistance(menter);
                list1.add(storeDto);

            }
            //筛选type以及分页1.综合排序2.距离排序3.销量排序
            list1=Sort.listSort(list1,type);
            List<StoreDto> list1New = new ArrayList<>();
            for(int i=0;i<list1.size();i++){
                if(i >= (page - 1) * 10 && i < page * 10){
                    list1New.add(list1.get(i));
                }
            }
            return list1New;
        }
    }

}