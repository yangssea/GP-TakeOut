package com.example.api.token;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/t")
public class Tests {
    @GetMapping("test")
    public String upload(){
        return "仲裁委";
    }
}
