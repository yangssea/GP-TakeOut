package com.example.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
/**
 * 商品实体类
 */
@Data
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int storeId;
    @Column(length = 10)
    private Long typeId;
    @Column(length = 255)
    private String name;
    @Column(length = 32)
    private BigDecimal price;
    @Column(length = 255)
    private String img;
    @Column(length = 255)
    private String remark;
    @Column(length = 255)
    private int sum;
    @Column(length = 10)
    private int useStatus;


}
