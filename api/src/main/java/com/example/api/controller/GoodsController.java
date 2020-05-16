package com.example.api.controller;

import com.example.api.config.token.PassToken;
import com.example.api.config.token.UserLoginToken;
import com.example.api.entity.Goods;
import com.example.api.entity.GoodsType;
import com.example.api.service.impl.GoodsServiceImpl;
import com.example.api.util.FileUtils;
import com.example.api.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

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

    @GetMapping("/findAll")
    @PassToken
    public Object finds(@RequestParam int id,@RequestParam Long type)  throws IllegalAccessException{
        return ResponseBuilder.success(goodsService.findAll(id,type));
    }

    @PostMapping("/save")
    @PassToken
    public Object save(@RequestBody Goods goodsType) throws IllegalAccessException{
        return ResponseBuilder.success(goodsService.save(goodsType));
    }

    @GetMapping("/delete")
    @PassToken
    public Object deletes(@RequestParam int id)  throws IllegalAccessException{
        return ResponseBuilder.success(goodsService.delete(id));
    }

    @RequestMapping("/fileUpload")
    @PassToken
    public String upload(@RequestParam("fileName") MultipartFile file, @RequestParam int storeId, @RequestParam Long goodsid, @RequestParam String name, @RequestParam BigDecimal price, @RequestParam String remark) {
        // 要上传的目标文件存放路径
        String localPath = "D:/tomcat/webapps/image";
        // 上传成功或者失败的提示
        String msg = FileUtils.upload(file, localPath, file.getOriginalFilename());
        if (msg.equals("")) {
            // 上传成功，给出页面提示
            msg = "null";
        }
        Goods goods=new Goods();
        goods.setName(name);
        goods.setPrice(price);
        goods.setStoreId(storeId);
        goods.setTypeId(goodsid);
        goods.setImg(msg);
        goodsService.save(goods);
        return "suceess";
    }
}
