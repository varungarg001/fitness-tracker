package com.project.fitness.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {

    private final String secret_key = "YS1zdHJpbmctc2VjcmV0LWF0LWxlYXN0LTI1Ni1iaXRzLWxvbmc=";
    private final int timeInMs = 86400000;

    public String generateToken(String userId,String role){
        return Jwts
                .builder()
                .subject(userId)
                .claim("role", List.of(new SimpleGrantedAuthority(role).getAuthority()))
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime()+timeInMs))
                .signWith(generateKey())
                .compact();
    }

    public boolean validateToken(String token){
        return false;
    }

    public String getIdFromToken(String token){
        return null;
    }

    public String getAllClaims(String token){
        return null;
    }

    public String getJwtTokenFromRequestHeader(HttpServletRequest request){
        return null;
    }

    private  Key generateKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret_key));
    }
}
