package com.example.appColectivos.controller;

import com.example.appColectivos.domain.Usuario;
import com.example.appColectivos.dto.LoginResponseDto;
import com.example.appColectivos.service.AuthService;
import com.example.appColectivos.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    private final AuthService authService;

    public AuthController(JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        Usuario registeredUser = authService.registerUser(usuario);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody Usuario usuario) {
        Usuario authenticatedUser = authService.authenticateUser(usuario);
        String token = jwtService.generateToken(authenticatedUser);
        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}