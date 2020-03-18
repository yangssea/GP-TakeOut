package com.example.api.entity;

import javax.persistence.*;
import java.math.BigDecimal;

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
