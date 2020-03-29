package com.example.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
/**
 * 广告实体类
 */
@Data
@Entity
@Table(name = "advertising")
public class Advertising
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
}
