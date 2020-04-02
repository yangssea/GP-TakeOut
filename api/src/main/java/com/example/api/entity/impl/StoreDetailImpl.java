package com.example.api.entity.impl;

import com.example.api.entity.StoreDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/2  15:05
 */
@Repository
public interface StoreDetailImpl extends JpaRepository<StoreDetail, Long> {
    List<Object> findAllBy();
}
