package com.example.api.service.impl;

import com.example.api.entity.Coupons;
import com.example.api.entity.StoreDetail;
import com.example.api.entity.dto.StoreDto;
import com.example.api.entity.impl.CouponsImpl;
import com.example.api.entity.impl.GradeImpl;
import com.example.api.entity.impl.OrdersImpl;
import com.example.api.entity.impl.StoreDetailImpl;
import com.example.api.service.StoreDetailService;
import com.example.api.util.GetDistanceMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
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
    @Override
    public Object getStoreList(int page, int type,double lat,double lng) {
        //商店类型选择
        List<StoreDetail> list =new ArrayList<>();
        List<StoreDetail> listNew =new ArrayList<>();
        List<StoreDto> list1 = new ArrayList<>();
        if(type==0){
            list = storeDetailImpl.findStoreAll();
        }else if(type<0||type>5){
            return "类型错误";
        }else{
            list = storeDetailImpl.findType(type);
        }
        //筛选地址
        for(int i=0;i<list.size();i++) {
            int sum = 0;
            double menter;
            if (list.get(i).getLatitude() == null || list.get(i).getLatitude().equals("") || list.get(i).getLongitude().equals("") || list.get(i).getLongitude().equals("")) {
                menter = 0.0;
            } else {
                menter = GetDistanceMeter.getMeter(lat, lng, Double.parseDouble(list.get(i).getLatitude()), Double.parseDouble(list.get(i).getLongitude()));
            }
            //如果小于15000米则选为附近店铺
            if(menter<15000){
                listNew.add(list.get(i));
            }
        }
        //page从1开始
        //筛选type
        list=listNew;
        if(list==null&&list.size()<10){
            return list;
        }else{
            //将list数据写进list1
            for(int i=0;i<list.size();i++){
                if(i>=(page-1)*10&&i<page*10){
                    StoreDto storeDto=new StoreDto();
                    storeDto.setStoreDetail(list.get(i));
                    //经纬度获取

                    //获取商店评分
                    String o=gradeImpl.find(list.get(i).getId());
                    if(o==null||o.equals("")||(o.split(",")[0].substring(0,1).equals("n"))){
                        storeDto.setGrade("0");
                    }else{
                        double grade=(Double.valueOf(o.split(",")[0])+Double.valueOf(o.split(",")[1])+Double.valueOf(o.split(",")[2]))/3.0;
                        storeDto.setGrade(String.format("%.1f", grade));
                    }
                    //获取当前年月份
                    Calendar cale = null;
                    cale = Calendar.getInstance();
                    int year = cale.get(Calendar.YEAR);
                    int month = cale.get(Calendar.MONTH) + 1;
                    String like="";
                    if (month < 10) {
                         like="0"+month;
                    }else{
                        like+=month;
                    }
                    //获取订单数
                    String orders= orderImpl.selectBySum(list.get(i).getId(),"%"+year+"-"+like+"%");
                    storeDto.setOrderSum(Integer.parseInt(orders));
                    //获取优惠列表
                    List<Coupons> liatCou=couponsImpl.getByStoreId(list.get(i).getId());
                    storeDto.setList(liatCou);
                    list1.add(storeDto);
                }
            }
            return list1;
        }
    }
}
