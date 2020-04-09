package com.example.api.service;

/**
 * @author yzx
 * @date 2020/4/8  20:27
 */
public interface GoodService {
    Object getGoodsList(int id);
    Object getGoodsType(Long id);
    Object getGrade(int id);
    Object getEvaluation(int id, int type);
}
