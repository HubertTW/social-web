package com.example.social_web.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/*
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String generateToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 小時有效
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

}
*/