package com.example.api.service.impl;

import com.example.api.entity.User;
import com.example.api.entity.UserAddress;
import com.example.api.entity.impl.UserAddressImpl;
import com.example.api.service.UserAddressService;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yzx
 * @date 2020/3/30  18:42
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {
   @Autowired
    private UserAddressImpl userAddressImpl;
    @Override
    public UserAddress findAll() {
        UserAddress serAddress = userAddressImpl.findAllBy();
        return serAddress;
    }

    @Override
    public Object save(UserAddress userAddress) {
        Object rst = (Object) userAddressImpl.save(userAddress);
        return rst;
    }
}
