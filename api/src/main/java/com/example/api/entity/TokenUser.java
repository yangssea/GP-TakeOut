package com.example.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 登录token实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenUser {
    String id;
    String username;
    String password;
}