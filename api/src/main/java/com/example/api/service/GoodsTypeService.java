package com.example.api.service;

import com.example.api.entity.GoodsType;

/**
 * @author yzx
 * @date 2020/5/15  18:33
 */

public interface GoodsTypeService {
    Object findAll(Long id);
    Object save(GoodsType goodsType);
    Object detele(int id);
    Object update(GoodsType goodsType);
}
