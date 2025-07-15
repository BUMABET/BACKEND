package com.example.heosejin.global.security.jwt;

import com.example.heosejin.common.dto.response.TokenSet;
import com.example.heosejin.global.config.properties.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;

    public TokenSet makeToken(String email, String grade) {
        String accessToken = createAccessToken(email, grade);
        String refreshToken = createRefreshToken(email, grade);
        return new TokenSet(accessToken, refreshToken);
    }

    private String createAccessToken(String email, String grade) {
        return createToken(email, grade, jwtProperties.getAccessExp());
    }

    private String createRefreshToken(String email, String grade) {
        return createToken(email, grade, jwtProperties.getRefreshExp());
    }

    private String createToken(String email, String grade, Long exp) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + exp);

        return Jwts.builder()
                .setSubject(email)
                .claim("grade", grade)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}
