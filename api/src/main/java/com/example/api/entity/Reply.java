package com.example.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
/**
 * 评论回复实体类
 */
@Data
@Entity
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int evaluationId;
    @Column(length = 255)
    private int userId;
    @Column(length = 255)
    private String comment;
    @Column(length = 255)
    private String img;
}
