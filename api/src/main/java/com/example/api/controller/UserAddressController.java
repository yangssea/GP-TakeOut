package com.example.api.controller;

import com.example.api.entity.UserAddress;
import com.example.api.service.impl.UserAddressServiceImpl;
import com.example.api.util.ResponseBuilder;
import org.springframework.web.bind.annotation.*;

/**
 * @author yzx
 * @date 2020/3/30  18:56
 */
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {
    private UserAddressServiceImpl userAddressService;
    @PostMapping("save")
    public Object save(@RequestBody UserAddress userAddress) throws IllegalAccessException {
        Object res=userAddressService.save(userAddress);
        return ResponseBuilder.success(res);
    }

    @GetMapping("findAll")
    public Object  findAll() throws IllegalAccessException {
        return ResponseBuilder.success(userAddressService.findAll());
    }

}
