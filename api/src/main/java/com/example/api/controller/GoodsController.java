package com.example.api.controller;

import com.example.api.config.token.UserLoginToken;
import com.example.api.service.impl.GoodsServiceImpl;
import com.example.api.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yzx
 * @date 2020/4/8  21:13
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;

    @GetMapping("find")
    @UserLoginToken
    public Object find(@RequestParam int id) throws IllegalAccessException {
        Object res=goodsService.getGoodsList(id);
        return ResponseBuilder.success(res);
    }
    @GetMapping("findType")
    @UserLoginToken
    public Object findType(@RequestParam Long id) throws IllegalAccessException {
        Object res=goodsService.getGoodsType(id);
        return ResponseBuilder.success(res);
    }
}
