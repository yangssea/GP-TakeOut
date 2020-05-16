package com.example.api.service;

import com.example.api.entity.Goods;

/**
 * @author yzx
 * @date 2020/4/8  20:27
 */
public interface GoodService {
    Object getGoodsList(int id);
    Object getGoodsType(Long id);
    Object getGrade(int id);
    Object getEvaluation(int id, int type);
    Object findAll(int id,Long type);
    Object save(Goods goods);
    Object delete(int id);
}
