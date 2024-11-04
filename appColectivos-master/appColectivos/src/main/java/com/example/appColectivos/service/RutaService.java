package com.example.appColectivos.service;

import com.example.appColectivos.domain.Ruta;
import com.example.appColectivos.repository.RutaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaService {
    private final RutaRepository rutaRepository;

    public RutaService(RutaRepository rutaRepository) {
        this.rutaRepository = rutaRepository;
    }

    public Ruta getRuta(String ciudadOrigen, String ciudadDestino) {
        return rutaRepository.findByCiudadOrigen_NombreAndCiudadDestino_Nombre(ciudadOrigen, ciudadDestino);
    }
}
