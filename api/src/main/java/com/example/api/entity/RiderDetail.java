package com.example.api.entity;

import javax.persistence.*;
/**
 * 骑手详细实体类
 */
@Entity
@Table(name = "riderDetail")
public class RiderDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private String img;
    @Column(length = 255)
    private String content;
    @Column(length = 255)
    private String phone;
}
