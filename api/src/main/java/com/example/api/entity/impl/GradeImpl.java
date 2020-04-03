package com.example.api.entity.impl;

import com.example.api.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yzx
 * @date 2020/4/2  21:03
 */
@Repository
public interface GradeImpl  extends JpaRepository<Grade, Long>{
    //其中查询的userid为storedetail id
    @Query("select AVG(a.gradeGoods),avg(a.graderide),avg(a.gradeTaste) from Grade a where a.userId=:id")
    String find(@Param("id") int id);
}
