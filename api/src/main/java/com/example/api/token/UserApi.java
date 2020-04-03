package com.example.api.token;

import com.example.api.entity.TokenUser;
import com.example.api.entity.User;
import com.example.api.service.impl.UserServiceImpl;
import com.example.api.util.GetId;
import com.example.api.util.ResponseBuilder;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录controller
 */

@RestController
@RequestMapping("/api")
public class UserApi {

    private GetToken tokenService = new GetToken();
    @Autowired
    private UserServiceImpl userService;
    //登录
    @PostMapping("/login")
    @PassToken
    public Object login(@RequestBody TokenUser user){
        JSONObject jsonObject=new JSONObject();
        TokenUser userForBase=new TokenUser("3","张三","123456");
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    //小程序用户登录处理
    @PostMapping("wLogin")
    @PassToken
    public Object xcToken(@RequestParam Object code){
        String url="https://api.weixin.qq.com/sns/jscode2session?";
        url+="appid=wx03b13f074270820d&secret=7a664176aae69b84c33fe38b1f424d52&js_code="+code+"&grant_type=authorization_code";
        com.alibaba.fastjson.JSONObject res = GetId.get(url);
        JSONObject jsonObject=new JSONObject();
        if(!res.getString("openid").equals("")){
            String oid = res.getString("openid");
            Object finduser=userService.findUser(oid);
            if(finduser==null){
                User saveUser=new User();
                saveUser.setOpenId(oid);
                saveUser.setType(1);
                userService.saveUser(saveUser);
            }
            User users=(User) userService.findUser(oid);
            TokenUser user=new TokenUser(users.getId()+"","",oid);
            String token = tokenService.getToken(user);
            jsonObject.put("token", token);
            jsonObject.put("userId", users.getId());
            System.out.println(res.getString("openid"));
        }
        return jsonObject;
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public Object getMessage()  throws IllegalAccessException{
        return ResponseBuilder.success();
    }
}