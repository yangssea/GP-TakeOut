package com.example.api.entity.impl;

import com.example.api.entity.Goods;
import com.example.api.entity.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/8  20:25
 */
@Repository
public interface GoodsTypeImpl extends JpaRepository<GoodsType, Long> {
    List<GoodsType> findByStoreId(Long id);
}
