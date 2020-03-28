package com.example.api.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @author yzx
 * @date 2020/3/28  16:31
 */
public class GetId {
    public static JSONObject get(String url){
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String strbody= restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody();
        JSONObject jsonObject= JSON.parseObject(strbody);
        System.out.println(jsonObject);
        return jsonObject;
    }
}
