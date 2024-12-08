package com.example.appColectivos.service;

import com.example.appColectivos.domain.Ciudad;
import com.example.appColectivos.repository.CiudadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadService {
    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public List<Ciudad> getCiudades() {
        return ciudadRepository.findAll();
    }
}
