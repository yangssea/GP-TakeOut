package com.example.api.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 商店详细实体类
 */
@Data
@Entity
@Table(name = "storeDetail")
public class StoreDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private int userId;
    //1.美食2.超市3.水果4.晚餐5.汉堡6速食7蔬菜8大牌9炸鸡10粥铺
    @Column(length = 10)
    private String type;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String latitude;
    @Column(length = 255)
    private String longitude;
    @Column(length = 255)
    private String shippingFee;
    @Column(length = 255)
    private String shippingTimeLength;
    @Column(length = 255)
    private String startFee;
    @Column(length = 255)
    private String img;
    @Column(length = 255)
    private String content;
    @Column(length = 255)
    private String address;
    @Column(length = 255)
    private String phone;
    @Column(length = 10)
    private int useStatus;
    @Column(length = 10)
    private int disableStatus;
}
