package com.example.api.entity;



import javax.persistence.*;
/**
 * 用户实体类
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(length = 10)
    private int type;
    @Column(length = 255)
    private String name;
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
