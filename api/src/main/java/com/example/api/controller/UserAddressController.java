package com.example.api.controller;

import com.example.api.entity.UserAddress;
import com.example.api.service.impl.UserAddressServiceImpl;
import com.example.api.token.UserLoginToken;
import com.example.api.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yzx
 * @date 2020/3/30  18:56
 */
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {
    @Autowired
    private UserAddressServiceImpl userAddressService;
    @PostMapping("save")
    @UserLoginToken
    public Object save(@RequestBody UserAddress userAddress) throws IllegalAccessException {
        Object res=userAddressService.save(userAddress);
        return ResponseBuilder.success(res);
    }

    @GetMapping("findAll")
    @UserLoginToken
    public Object  findAll() throws IllegalAccessException {
        Object res=userAddressService.findAll();
        return ResponseBuilder.success(res);
    }

}
