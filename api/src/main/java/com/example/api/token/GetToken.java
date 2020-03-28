package com.example.api.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.api.entity.TokenUser;

import java.util.Date;

/**
 * 生成token
 */
public class GetToken {
    public String getToken(TokenUser user) {
       /* String token="";
        token= JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));*/
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
