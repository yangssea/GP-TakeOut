package com.example.api.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
/**
 * 订单详细实体类
 */
@Data
@Entity
@Table(name = "orderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int OrderId;
    @Column(length = 255)
    private String priceName;
    @Column(length = 255)
    private Long goodsId;
    @Column(length = 255)
    private int sum;
    @Column(length = 255)
    private BigDecimal price;
}