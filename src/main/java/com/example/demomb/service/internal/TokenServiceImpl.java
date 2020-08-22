package com.example.demomb.service.internal;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demomb.entity.dao.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TokenServiceImpl {
    public String getToken(UserEntity user) {
        String token = "";
        token = JWT.create().withAudience(user.getId().toString()).withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 1))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;

    }
}
