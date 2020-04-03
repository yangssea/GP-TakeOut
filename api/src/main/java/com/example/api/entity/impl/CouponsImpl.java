package com.example.api.entity.impl;

import com.example.api.entity.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/3  11:52
 */
@Repository
public interface CouponsImpl extends JpaRepository<Coupons, Long> {
    List<Coupons> getByStoreId(int id);
}
