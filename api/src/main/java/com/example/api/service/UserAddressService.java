package com.example.api.service;

import com.example.api.entity.UserAddress;

/**
 * @author yzx
 * @date 2020/3/30  18:41
 */

public interface UserAddressService {
    UserAddress findAll();
    Object save(UserAddress userAddress);
}
