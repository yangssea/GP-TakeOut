package com.example.api.entity;

import javax.persistence.*;
import java.math.BigDecimal;

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
