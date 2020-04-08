package com.example.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author yzx
 * @date 2020/4/8  20:06
 */
@Data
@Entity
@Table(name = "goodsType")
public class GoodsType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private Long storeId;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String remark;
}