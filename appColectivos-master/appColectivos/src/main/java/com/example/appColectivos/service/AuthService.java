package com.example.appColectivos.service;

import com.example.appColectivos.domain.Usuario;
import com.example.appColectivos.repository.UsuarioRepositorio;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public Usuario registerUser(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepositorio.save(usuario);
    }

    public Usuario authenticateUser(Usuario usuario) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getMail(), usuario.getPassword())
        );

        return usuarioRepositorio.findByMail(usuario.getMail())
                .filter(user -> passwordEncoder.matches(usuario.getPassword(), user.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}