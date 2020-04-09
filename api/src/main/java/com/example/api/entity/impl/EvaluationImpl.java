package com.example.api.entity.impl;

import com.example.api.entity.Coupons;
import com.example.api.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzx
 * @date 2020/4/9  17:04
 */
@Repository
public interface EvaluationImpl  extends JpaRepository<Evaluation, Long> {
    @Query("select e from Evaluation e left join Orders o on o.id=e.orderId where o.storeId=:id")
    List<Evaluation> getList(@Param("id") int id);
    @Query("select e from Evaluation e left join Orders o on o.id=e.orderId where o.storeId=:id and e.type=:type")
    List<Evaluation> getListType(@Param("id") int id,@Param("type") int type);
    @Query("select e from Evaluation e left join Orders o on o.id=e.orderId where o.storeId=:id order by e.time")
    List<Evaluation> getListTime(@Param("id") int id);
}
