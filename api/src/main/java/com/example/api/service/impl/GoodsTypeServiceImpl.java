package com.example.api.service.impl;

import com.example.api.entity.GoodsType;
import com.example.api.entity.impl.GoodsTypeImpl;
import com.example.api.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yzx
 * @date 2020/5/15  18:35
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeImpl goodsTypeImpl;
    @Override
    public Object findAll(Long id) {
        return goodsTypeImpl.findByStoreId(id);
    }

    @Override
    public Object save(GoodsType goodsType) {
        return goodsTypeImpl.save(goodsType);
    }

    @Override
    public Object detele(int id) {
        return  goodsTypeImpl.deletes(id);
    }

    @Override
    public Object update(GoodsType goodsType) {
        return goodsTypeImpl.save(goodsType);
    }
}
