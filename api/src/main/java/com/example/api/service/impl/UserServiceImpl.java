package com.example.api.service.impl;

import com.example.api.entity.User;
import com.example.api.entity.impl.UserImpl;
import com.example.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yzx
 * @date 2020/3/29  10:58
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserImpl userImpl;
    @Override
    public User saveUser(User user) {
        User result=userImpl.save(user);
        return result;
    }

    @Override
    public Object findUser(String id) {
        Object result=userImpl.findByOpenId(id);;
        return result;
    }

    @Override
    public User findById(int id) {
        User result=userImpl.findById(id);;
        return result;
    }
}
