package com.example.appColectivos.controller;

import com.example.appColectivos.domain.Empresa;
import com.example.appColectivos.service.EmpresaService;
import org.springframework.http.ResponseEntity; // Importar ResponseEntity
import org.springframework.http.HttpStatus;    // Importar HttpStatus
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    // Obtener todas las empresas
    @GetMapping()
    public List<Empresa> getEmpresas() {
        var empresas = empresaService.findAllEmpresas();
        System.out.println(empresas);
        return empresas;
    }

    // Actualizar una empresa por ID
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresaDetails) {
        Empresa updatedEmpresa = empresaService.updateEmpresa(id, empresaDetails);
        return ResponseEntity.ok(updatedEmpresa);
    }

    // Eliminar una empresa por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id) {
        empresaService.deleteEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}


