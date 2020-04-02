package com.example.api.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 赞助实体类
 */
@Data
@Entity
@Table(name = "coupons")
public class Coupons {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    @NonNull
    private int storeId;
    //店铺红包类型
    @Column(length = 255)
    @NonNull
    private int type;
    //店铺或客服端优惠类型
    @NonNull
    @Column(length = 255)
    private int allType;
    //折扣
    @Column(length = 255)
    private String  discount;
    //满减开始
    @Column(length = 255)
    private String start;
    //满减结束
    @Column(length = 255)
    private String end;
    //满减结束
    @Column(length = 255)
    private String content;
    //过期时间
    @NonNull
    @Column(length = 255)
    @Temporal(TemporalType.DATE)
    private Date time;


}
