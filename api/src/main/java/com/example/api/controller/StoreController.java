package com.example.api.controller;

import com.example.api.service.impl.StoreDetailServiceImpl;
import com.example.api.config.token.UserLoginToken;
import com.example.api.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yzx
 * @date 2020/4/3  9:15
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreDetailServiceImpl storeDetailService;
    @GetMapping("find")
    @UserLoginToken
    public Object find(@RequestParam int page,@RequestParam int type,@RequestParam String lat,@RequestParam String lng) throws IllegalAccessException {
        Object res=storeDetailService.getStoreList(page,type,Double.parseDouble(lat),Double.parseDouble(lng));
        return ResponseBuilder.success(res);
    }
    @GetMapping("findTo")
    @UserLoginToken
    public Object findTo(@RequestParam int page,@RequestParam int type,@RequestParam String lat,@RequestParam String lng,@RequestParam String find) throws IllegalAccessException {
        Object res=storeDetailService.findStoreList(page,type,Double.parseDouble(lat),Double.parseDouble(lng),find);
        return ResponseBuilder.success(res);
    }
}
