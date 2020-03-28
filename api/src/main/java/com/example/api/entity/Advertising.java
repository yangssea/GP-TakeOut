package com.example.api.entity;

import javax.persistence.*;
import java.math.BigDecimal;
/**
 * 广告实体类
 */
@Entity
@Table(name = "advertising")
public class Advertising
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
}
