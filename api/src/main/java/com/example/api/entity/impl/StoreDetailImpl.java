package com.example.api.entity.impl;

import com.example.api.entity.StoreDetail;
import com.example.api.entity.dto.StoreDto;
import org.apache.catalina.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/2  15:05
 */
@Repository
public interface StoreDetailImpl extends JpaRepository<StoreDetail, Long> {
    @Query("select a from StoreDetail a")
    List<StoreDetail> findStoreAll();
    @Query("select distinct a from StoreDetail a left join Coupons c on a.id = c.storeId where c.type =:id")
    List<StoreDetail> findType(@Param("id") int type);
}
