package com.example.api.entity.impl;

import com.example.api.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/2  15:10
 */
@Repository
public interface OrdersImpl extends JpaRepository<Orders, Long> {
    @Query(value = "select count(*) from orders as  a where a.store_id =:id and a.order_time like :times",nativeQuery = true)
    String selectBySum(@Param("id") int id,@Param("times") String times);

    List<Orders> findByUserId(int id);

    List<Orders> findByStoreId(int id);

    List<Orders> findByStatus(int id);

    @Modifying
    @Transactional
    @Query(value = "update orders set status=:status where id=:id", nativeQuery = true)
    int updates(@Param("status") int status,@Param("id") int id);
}
