package com.example.api.controller;

import com.example.api.config.token.PassToken;
import com.example.api.config.token.UserLoginToken;
import com.example.api.entity.dto.OrderDto;
import com.example.api.service.impl.OrderServiceImpl;
import com.example.api.service.impl.StoreDetailServiceImpl;
import com.example.api.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yzx
 * @date 2020/4/11  10:10
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    //查询优惠类型
    @GetMapping("findCou")
    @UserLoginToken
    public Object findCou(@RequestParam int id) throws IllegalAccessException {
        Object res=orderService.findCoupons(id);
        return ResponseBuilder.success(res);
    }

    //保存订单
    @PostMapping("save")
    @UserLoginToken
    public Object save(@RequestBody OrderDto orderDto) throws IllegalAccessException {
        Object res=orderService.save(orderDto);
        return ResponseBuilder.success(res);
    }

    //查询订单
    @GetMapping("findAll")
    @UserLoginToken
    public Object findAll(@RequestParam int id) throws IllegalAccessException {
        Object res=orderService.findAll(id);
        return ResponseBuilder.success(res);
    }

    //查询店铺订单
    @GetMapping("findSid")
    @PassToken
    public Object findSid(@RequestParam int id) throws IllegalAccessException {
        Object res=orderService.findSid(id);
        return ResponseBuilder.success(res);
    }

    //修改店铺订单
    @GetMapping("update")
    @PassToken
    public Object update(@RequestParam int st,@RequestParam int id) throws IllegalAccessException {
        Object res=orderService.update(st,id);
        return ResponseBuilder.success(res);
    }
    //查询店铺订单
    @GetMapping("getAll")
    @PassToken
    public Object getAll(@RequestParam int id) throws IllegalAccessException {
        Object res=orderService.findDv(id);
        return ResponseBuilder.success(res);
    }
}
