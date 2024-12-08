package com.example.appColectivos.controller;

import com.example.appColectivos.domain.Ciudad;
import com.example.appColectivos.service.CiudadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ciudades")
public class CiudadController {
    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public List<Ciudad> getCiudades() {
        return ciudadService.getCiudades();
    }
}
