package com.example.api.entity.impl;

import com.example.api.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yzx
 * @date 2020/4/2  15:10
 */
@Repository
public interface OrdersImpl extends JpaRepository<Orders, Long> {
    @Query(value = "select count(*) from orders as  a where a.store_id =:id and a.order_time like :times",nativeQuery = true)
    String selectBySum(@Param("id") int id,@Param("times") String times);
}
