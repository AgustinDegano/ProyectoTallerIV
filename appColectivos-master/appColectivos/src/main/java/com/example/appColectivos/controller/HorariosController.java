package com.example.appColectivos.controller;

import com.example.appColectivos.domain.Horarios;
import com.example.appColectivos.service.HorariosService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorariosController {
    private final HorariosService horariosService;

    public HorariosController(HorariosService horariosService) {
        this.horariosService = horariosService;
    }

    @GetMapping
    public List<Horarios> getHorarios() {
        return horariosService.getHorarios();
    }

    @GetMapping("/{id}")
    public Horarios getHorario(@PathVariable Long id) {
        return horariosService.getHorario(id);
    }

    @GetMapping("/rutas")
    public List<Horarios> getHorarioByRutaAndHorarioDeSalida(@RequestParam(name = "ci", required = true) String ci,
                                                             @RequestParam(name = "cf", required = true) String cf,
                                                             @RequestParam(name = "hs", required = true) String hs,
                                                             @RequestParam(name = "hl", required = true) String hl) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime horarioSalida = LocalTime.parse(hs, formatter);
        LocalTime horarioLlegada = LocalTime.parse(hl, formatter);
        // comentario test
        return horariosService.getHorariosByRutaId(ci, cf, horarioSalida, horarioLlegada);
    }
}




