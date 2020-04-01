package com.example.api.entity.impl;

import com.example.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzx
 * @date 2020/3/29  10:21
 */

@Repository
public interface UserImpl extends JpaRepository<User, Long> {
    //多属性查询接口
    User findByOpenId(String openId);
    User findById(String id);
    /*//自定义属性查询接口
    @Query("SELECT O FROM User O WHERE O.name = :name1  OR O.name = :name2 ")
    List<User> findTwoName(@Param("name1") String name1, @Param("name2") String name2);

    //原生sql语句查询
    @Query(nativeQuery = true, value = "SELECT * FROM AUTH_USER WHERE name = :name1  OR name = :name2 ")
    List<User> findSQL(@Param("name1") String name1, @Param("name2") String name2);*/
}