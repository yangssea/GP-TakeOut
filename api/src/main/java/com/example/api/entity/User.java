package com.example.api.entity;



import lombok.Data;

import javax.persistence.*;
/**
 * 用户实体类
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "int(10) comment '1小程序2商家3骑手4管理员...'")
    private int type;
    @Column(length = 255)
    private String name;
    @Column(columnDefinition = "varchar(255) comment '小程序用户唯一标识...'")
    private String openId;
    @Column(length = 255)
    private String password;
    @Column(length = 255)
    private String img;
    @Column(length = 255)
    private String address;
    @Column(length = 255)
    private String phone;
    @Column(length = 10)
    private int disableStatus;
}
