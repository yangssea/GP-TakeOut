package com.example.api.service;

import com.example.api.entity.UserAddress;

import java.util.List;

/**
 * @author yzx
 * @date 2020/3/30  18:41
 */

public interface UserAddressService {
    List<UserAddress> findAll(Long id);
    UserAddress save(UserAddress userAddress);
}
