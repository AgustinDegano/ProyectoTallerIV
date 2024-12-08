package com.example.appColectivos.service;

import com.example.appColectivos.domain.Empresa;
import com.example.appColectivos.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> findAllEmpresas() {
        return this.empresaRepository.findAll();
    }
}
