package com.example.token;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "itsmyownsecretkeyyjutrgefrgtdhyjuetwrefsgdhjytrsgfdh";
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // Generate token with custom expiry in minutes
    public String generateToken(String username, int minutes) {
        long expiration = 1000L * 60 * minutes; // convert minutes to milliseconds
        return Jwts.builder()
                .setSubject(username)
                .setId(java.util.UUID.randomUUID().toString()) // add unique ID
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }


    // Extract username from token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
