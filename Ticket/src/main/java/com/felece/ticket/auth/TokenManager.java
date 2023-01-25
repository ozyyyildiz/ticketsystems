package com.felece.ticket.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenManager {

    @Value("${felece.ticket.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${felece.ticket.jwtSecret}")
    private String jwtTokenKey;

    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtTokenKey)
                .compact();
    }

    public boolean tokenValidate(String token){
        if(getUsernameToken(token) != null && isExpired(token)){
            return true;
        }else{
            return false;
        }
    }

    public String getUsernameToken(String token){
        return getClaims(token).getSubject();
    }

    public boolean isExpired(String token){
        return getClaims(token).getExpiration().after(new Date());
    }

    private Claims getClaims(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtTokenKey).parseClaimsJws(token).getBody();
        return claims;
    }

}
