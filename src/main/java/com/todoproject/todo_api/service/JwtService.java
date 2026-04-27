package com.todoproject.todo_api.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

        private final String SECRET = "mySecretKey123456789012345678901234";

        private SecretKey getKey() {

                return Keys.hmacShaKeyFor(
                                SECRET.getBytes(StandardCharsets.UTF_8));
        }

        // Générer token
        public String generateToken(String username) {

                return Jwts.builder()
                                .setSubject(username)
                                .setIssuedAt(new Date())
                                .setExpiration(
                                                new Date(
                                                                System.currentTimeMillis()
                                                                                + 1000 * 60 * 60))
                                .signWith(getKey())
                                .compact();
        }

        // Extraire username du token
        public String extractUsername(String token) {

                return Jwts.parserBuilder()
                                .setSigningKey(getKey())
                                .build()
                                .parseClaimsJws(token)
                                .getBody()
                                .getSubject();
        }

        // Vérifier token
        public boolean validateToken(
                        String token,
                        String username) {

                String extractedUser = extractUsername(token);

                return extractedUser.equals(username);
        }
}