package com.example.appColectivos.service;

import com.example.appColectivos.domain.Usuario;
import com.example.appColectivos.repository.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }
}