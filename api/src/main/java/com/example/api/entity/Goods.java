package com.example.api.entity;

import javax.persistence.*;
import java.math.BigDecimal;
/**
 * 商品实体类
 */
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int storeId;
    @Column(length = 10)
    private int type;
    @Column(length = 255)
    private String name;
    @Column(length = 32)
    private BigDecimal price;
    @Column(length = 255)
    private String img;
    @Column(length = 255)
    private int sum;
    @Column(length = 10)
    private int useStatus;


}
