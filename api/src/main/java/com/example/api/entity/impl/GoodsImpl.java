package com.example.api.entity.impl;

import com.example.api.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/6  9:56
 */
@Repository
public interface GoodsImpl  extends JpaRepository<Goods, Long> {
    List<Goods> findByStoreId(int id);
}
