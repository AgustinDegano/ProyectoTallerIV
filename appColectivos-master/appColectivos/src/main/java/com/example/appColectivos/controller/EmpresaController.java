package com.example.appColectivos.controller;

import com.example.appColectivos.domain.Empresa;
import com.example.appColectivos.service.EmpresaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping()
    public List<Empresa> getEmpresas() {
        var empresas = empresaService.findAllEmpresas();
        System.out.println(empresas);
        return empresas;
    }
}
