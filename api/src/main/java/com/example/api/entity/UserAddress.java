package com.example.api.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author yzx
 * @date 2020/3/30  12:27
 */
@Data
@Entity
@Table(name = "userAdderss")
public class UserAddress {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    @NotNull
    private Long userId;
    @Column(length = 255)
    @NotEmpty
    @NotNull
    private String name;
    @Column(length = 255)
    @NotNull
    @Pattern(regexp = "^[0-9]*$")
    private String phone;
    @Column(length = 255)
    @NotNull
    private String address;
    @Column(length = 255)
    @NotNull
    private String latitude;
    @Column(length = 255)
    @NotNull
    private String longitude;
    @Column(length = 255)
    private String remark;

    public UserAddress(@NotNull Long userId, @NotEmpty @NotNull String name, @NotNull @Pattern(regexp = "^[0-9]*$") String phone, @NotNull String address, @NotNull String latitude, @NotNull String longitude, String remark) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.remark = remark;
    }
}
