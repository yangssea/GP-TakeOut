package com.example.api.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int storeId;
    @Column(length = 255)
    private int userId;
    @Column(length = 255)
    private BigDecimal price;
    @Column(length = 255)
    private String img;
    @Column(length = 255)
    private String OrderTime;
    @Column(length = 255)
    private String address;
    @Column(length = 255)
    private String deliveryMan;
    @Column(length = 255)
    private String deliveryManPhone;
    @Column(length = 10)
    private int status;
}