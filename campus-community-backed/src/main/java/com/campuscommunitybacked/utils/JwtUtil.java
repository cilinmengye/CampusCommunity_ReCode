package com.campuscommunitybacked.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String key = "campusCommunityBacked";

    public static String genToken(Map<String, Object> claims){
        return JWT.create()
                 .withClaim("claims", claims) //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*12))
                .sign(Algorithm.HMAC256(key));
    }

    public static Map<String, Object> parseToken (String token){
        return JWT.require(Algorithm.HMAC256(key))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
