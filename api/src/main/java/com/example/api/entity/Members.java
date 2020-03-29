package com.example.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 会员实体类
 */
@Data
@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int userId;
    @Column(length = 255)
    private int type;
}
