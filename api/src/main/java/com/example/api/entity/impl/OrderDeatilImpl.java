package com.example.api.entity.impl;

import com.example.api.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yzx
 * @date 2020/4/8  21:04
 */
@Repository

public interface OrderDeatilImpl extends JpaRepository<OrderDetail, Long> {
    @Query(value = "select count(*) from order_detail where goods_id=:id",nativeQuery = true)
    String selectBySum(@Param("id") int id);
}
