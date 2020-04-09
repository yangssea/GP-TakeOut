package com.example.api.service.impl;

import com.example.api.entity.Goods;
import com.example.api.entity.dto.GoodsListDto;
import com.example.api.entity.impl.GoodsImpl;
import com.example.api.entity.impl.GoodsTypeImpl;
import com.example.api.entity.impl.OrderDeatilImpl;
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
}
