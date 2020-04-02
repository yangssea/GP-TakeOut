package com.example.api.entity;

/**
 * @author yzx
 * @date 2020/4/2  14:39
 * 商家评分实体类
 */

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 商家评价实体类
 */
@Data
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int orderId;
    @Column(length = 255)
    private int userId;
    @Column(length = 255)
    private double gradeGoods;
    @Column(length = 255)
    private double graderide;
    @Column(length = 255)
    private double gradeTaste;
}
