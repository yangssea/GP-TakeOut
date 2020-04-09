package com.example.api.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商家评价实体类
 */
@Data
@Entity
@Table(name = "evaluation")
public class Evaluation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int orderId;
    public Evaluation() {
    }
    @Column(length = 255)
    private int userId;
    //0.好评1.差评
    @Column(length = 255)
    @NonNull
    private int type;
    @Temporal(TemporalType.DATE)
    private Date time;
    @Column(length = 255)
    private String comment;
    @Column(length = 255)
    private int isReply;
    @Column(length = 255)
    private String img;
}