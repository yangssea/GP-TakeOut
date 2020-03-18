package com.example.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "storeDetail")
public class StoreDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int userId;
    @Column(length = 10)
    private int type;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String img;
    @Column(length = 255)
    private String content;
    @Column(length = 255)
    private String address;
    @Column(length = 255)
    private String phone;
    @Column(length = 10)
    private int useStatus;
    @Column(length = 10)
    private int disableStatus;
}
