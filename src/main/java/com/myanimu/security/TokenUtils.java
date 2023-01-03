package com.myanimu.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "rDwOiO55xQe1POuau4vIlO7u13T7S1D4";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 86400L;

    public static String createToken(String username, String email){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000L;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("username", username);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuhentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes(StandardCharsets.UTF_8))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e){
            return null;
        }
    }
}
