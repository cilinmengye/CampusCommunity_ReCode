package com.campuscommunitybacked;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGen(){ //生成JWT
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", "1");
        claims.put("account", "202126202206");
        String token =  JWT.create()
                .withClaim("user", claims) //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*12))
                .sign(Algorithm.HMAC256("campusCommunityBacked"));
        System.out.println(token);
    }

    @Test
    public void testParse(){ //解析
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7ImlkIjoiMSIsImFjY291bnQiOiIyMDIxMjYyMDIyMDYifSwiZXhwIjoxNzE1Mjg4MTE1fQ." +
                "IX5vVBuw-ZGeGrEDtymKtAht695LyyQt4pVzUK38zKA";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("campusCommunityBacked")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
        //结果为：{"id":"1","account":"202126202206"}
    }
}
