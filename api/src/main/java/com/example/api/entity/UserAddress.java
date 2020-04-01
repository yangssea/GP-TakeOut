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
    @Pattern(regexp = "^[1-9]+(.[0-9]{1,30})?$")
    private String latitude;
    @Column(length = 255)
    @NotNull
    @Pattern(regexp = "^[1-9]+(.[0-9]{1,30})?$")
    private String longitude;
    @Column(length = 255)
    private String remark;
}
