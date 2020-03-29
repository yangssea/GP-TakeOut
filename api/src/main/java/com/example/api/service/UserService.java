package com.example.api.service;

import com.example.api.entity.User;

/**
 * @author yzx
 * @date 2020/3/29  10:12
 */

public interface UserService {
    User saveUser(User user);
    Object findUser(String id);
}
