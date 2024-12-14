package com.example.appColectivos.service;

import com.example.appColectivos.domain.Empresa;
import com.example.appColectivos.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    // Obtener todas las empresas
    public List<Empresa> findAllEmpresas() {
        return this.empresaRepository.findAll();
    }

    // Lógica de servicio para actualizar empresa
    public Empresa updateEmpresa(Long id, Empresa empresaDetails) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);

        if (optionalEmpresa.isPresent()) {
            Empresa existingEmpresa = optionalEmpresa.get();

            // Actualizar solo los campos necesarios
            existingEmpresa.setNombre(empresaDetails.getNombre());
            existingEmpresa.setTelefono(empresaDetails.getTelefono());
            existingEmpresa.setDireccion(empresaDetails.getDireccion());

            // Guardar y devolver la empresa actualizada
            return empresaRepository.save(existingEmpresa);
        } else {
            throw new RuntimeException("Empresa no encontrada con ID: " + id);
        }
    }

    // Lógica de servicio para eliminar empresa
    public void deleteEmpresa(Long id) {
        // Verificar si existe la empresa
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Empresa no encontrada con ID: " + id);
        }


    }
}