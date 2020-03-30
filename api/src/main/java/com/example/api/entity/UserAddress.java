package com.example.api.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yzx
 * @date 2020/3/30  12:27
 */
@Data
@Entity
@Table(name = "userAdderss")
public class UserAddress {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int userId;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String phone;
    @Column(length = 255)
    private String address;
    @Column(length = 255)
    private String latitude;
    @Column(length = 255)
    private String longitude;
    @Column(length = 255)
    private String reamrk;
}
