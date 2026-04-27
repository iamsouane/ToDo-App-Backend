package com.todoproject.todo_api.controller;

import com.todoproject.todo_api.dto.AuthRequest;
import com.todoproject.todo_api.dto.AuthResponse;
import com.todoproject.todo_api.service.JwtService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        if (request.getUsername().equals("user") &&
                request.getPassword().equals("user123")) {

            String token = jwtService.generateToken(request.getUsername());

            return new AuthResponse(token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}