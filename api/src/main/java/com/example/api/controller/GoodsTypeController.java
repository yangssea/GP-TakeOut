package com.example.api.controller;

import com.example.api.config.token.PassToken;
import com.example.api.entity.GoodsType;
import com.example.api.service.impl.GoodsServiceImpl;
import com.example.api.service.impl.GoodsTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.api.util.ResponseBuilder;


/**
 * @author yzx
 * @date 2020/5/15  18:53
 */
@RestController
@RequestMapping("/GoodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeServiceImpl goodsTypeService;

    @GetMapping("/findAll")
    @PassToken
    public Object find(@RequestParam Long id)  throws IllegalAccessException{
        return ResponseBuilder.success(goodsTypeService.findAll(id));
    }

    @PostMapping("/save")
    @PassToken
    public Object save(@RequestBody GoodsType goodsType) throws IllegalAccessException{
        return ResponseBuilder.success(goodsTypeService.save(goodsType));
    }

    @GetMapping("/delete")
    @PassToken
    public Object delete(@RequestParam int id)  throws IllegalAccessException{
        return ResponseBuilder.success(goodsTypeService.detele(id));
    }

}
