package com.example.api.controller;



import com.example.api.config.token.PassToken;
import com.example.api.service.WebSocketServer;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

/**
 * @author yzx
 * @date 2020/4/26  9:08
 */
@RestController
@RequestMapping("/orderSocket")
public class CheckCenterController{

    //页面请求
    @GetMapping("/socket/{cid}")
    @PassToken
    public String socket(@PathVariable String cid) {
        return "success";
    }
    @RequestMapping("/socket/push/{cid}")
    @PassToken
    public String pushToWeb(@PathVariable String cid,String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}



