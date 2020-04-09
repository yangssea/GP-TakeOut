package com.example.api.service.impl;

import com.example.api.entity.Evaluation;
import com.example.api.entity.Goods;
import com.example.api.entity.dto.GoodsListDto;
import com.example.api.entity.impl.*;
import com.example.api.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzx
 * @date 2020/4/8  20:28
 */
@Service
public class GoodsServiceImpl implements GoodService {
    @Autowired
    private GoodsImpl goods;

    @Autowired
    private GoodsTypeImpl goodsType;

    @Autowired
    private OrderDeatilImpl orderDeatil;

    @Autowired
    private GradeImpl gradeImpl;

    @Autowired
    private EvaluationImpl  evaluationImpl;

    //商店食物详细
    @Override
    public Object getGoodsList(int id) {
        List<Goods> list=goods.findByStoreIdOrderByTypeId(id);
        List<GoodsListDto> listNew=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            GoodsListDto goodsDto=new GoodsListDto();
            goodsDto.setGoods(list.get(i));
            String sum=orderDeatil.selectBySum(list.get(i).getId());
            goodsDto.setSum(sum);
            listNew.add(goodsDto);
        }
        return listNew;
    }

    //商店食物类型
    @Override
    public Object getGoodsType(Long id) {
        return goodsType.findByStoreId(id);
    }

    //获取商店评分
    @Override
    public Object getGrade(int id) {
        return gradeImpl.find(id);
    }

    @Override
    public Object getEvaluation(int id, int type) {
        if(type==1){
            return evaluationImpl.getListTime(id);
        }else if(type==2){
            //好评
            return evaluationImpl.getListType(id,0);
        }else if(type==3){
            return evaluationImpl.getListType(id,1);
        }else if(type==4){
            //有图
            List<Evaluation> list=evaluationImpl.getList(id);
            List<Evaluation> listNew=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                if(!list.get(i).getImg().equals("")&&list.get(i).getImg()!=null){
                    listNew.add(list.get(i));
                }
            }
            return listNew;
        }else{
            return evaluationImpl.getList(id);
        }
    }
    //获取商店评论与回复

}
