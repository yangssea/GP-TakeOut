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
    //商品列表
    @GetMapping("find")
    @UserLoginToken
    public Object find(@RequestParam int id) throws IllegalAccessException {
        Object res=goodsService.getGoodsList(id);
        return ResponseBuilder.success(res);
    }
    //商品类型列表
    @GetMapping("findType")
    @UserLoginToken
    public Object findType(@RequestParam Long id) throws IllegalAccessException {
        Object res=goodsService.getGoodsType(id);
        return ResponseBuilder.success(res);
    }
    //商店评分
    @GetMapping("findComment")
    @UserLoginToken
    public Object findComment(@RequestParam int id,@RequestParam int type) throws IllegalAccessException {
        Object res=goodsService.getEvaluation(id,type);
        return ResponseBuilder.success(res);
    }
    //商店评论列表
    @GetMapping("findGrade")
    @UserLoginToken
    public Object findGrade(@RequestParam int id) throws IllegalAccessException {
        Object res=goodsService.getGrade(id);
        return ResponseBuilder.success(res);
    }
}
