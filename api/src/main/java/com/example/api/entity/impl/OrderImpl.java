package com.example.api.entity.impl;

import com.example.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yzx
 * @date 2020/4/2  15:10
 */
@Repository
public interface OrderImpl extends JpaRepository<Order, Long> {
    @Query("select count(a) from Order  a where a.storeId =:id ")
    Object selectBySum(@Param("id") int id);
}
