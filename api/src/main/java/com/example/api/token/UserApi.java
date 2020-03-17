package com.example.api.token;

import com.example.api.entity.TokenUser;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserApi {

    private GetToken tokenService = new GetToken();
    //登录
    @PostMapping("/login")
    public Object login(@RequestBody TokenUser user){
        JSONObject jsonObject=new JSONObject();
        TokenUser userForBase=new TokenUser("2","张三","123456");
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
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}