package com.example.api.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 商家评价实体类
 */
@Entity
@Table(name = "evaluation")
public class Evaluation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int orderId;
    @Column(length = 255)
    private int userId;
    @Column(length = 255)
    private String comment;
    @Column(length = 255)
    private String img;
}