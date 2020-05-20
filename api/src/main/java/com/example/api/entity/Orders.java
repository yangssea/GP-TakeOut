package com.example.api.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 订单实体类
 */
@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int storeId;
    @Column(length = 255)
    private int userId;
    @Column(length = 255)
    private int riderId;
    @Column(length = 255)
    private BigDecimal price;
    @Column(length = 255)
    private String img;
    @Column(length = 255)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date OrderTime;
    @Column(length = 255)
    private String address;
    @Column(length = 255)
    private String remark;
    @Column(length = 255)
    private String lat;
    @Column(length = 255)
    private String lng;
    @Column(length = 255)
    private Long wareSum;
    @Column(length = 255)
    private String deliveryMan;
    @Column(length = 255)
    private String deliveryFee;
    @Column(length = 255)
    private String couponstype;
    @Column(length = 255)
    private String couponsMoney;
    @Column(length = 255)
    private String deliveryManPhone;
    //订单状态0.待支付1.备餐中2.已配送3.已完成4.已取消
    @Column(length = 10)
    private int status;
}