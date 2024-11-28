package com.example.appColectivos.service;

import com.example.appColectivos.domain.Horarios;
import com.example.appColectivos.domain.Ruta;
import com.example.appColectivos.repository.HorariosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HorariosService {
    private final HorariosRepository horariosRepository;
    private final RutaService rutaService;

    public HorariosService(HorariosRepository horariosRepository, RutaService rutaService){
        this.horariosRepository = horariosRepository;
        this.rutaService = rutaService;
    }

    public List<Horarios> getHorarios(){
        return horariosRepository.findAll();
    }

    public Horarios getHorario(Long id){
        return horariosRepository.findById(id).orElse(null);
    }

    public List<Horarios> getHorariosByRutaId(String ciudadOrigen, String ciudadDestino, LocalTime horaSalida, LocalTime horaLlegada){
        if (ciudadOrigen.equalsIgnoreCase("rosario") && ciudadDestino.equalsIgnoreCase("esperanza")) {
            Ruta ruta1 = rutaService.getRuta(ciudadOrigen, "Santa Fe");
            Ruta ruta2 = rutaService.getRuta("Santa Fe", ciudadDestino);
            List<Horarios> horarios1 = horariosRepository
                    .findAllByRutaIdAndHoraSalidaGreaterThanEqualAndHoraLlegadaLessThanEqual(ruta1.getId(), horaSalida, horaLlegada)
                    .stream()
                    .filter(horario -> !horario.getHoraSalida().isAfter(horaLlegada))
                    .toList();
            List<Horarios> horarios2 = horariosRepository
                    .findAllByRutaIdAndHoraSalidaGreaterThanEqualAndHoraLlegadaLessThanEqual(ruta2.getId(), horaSalida, horaLlegada)
                    .stream()
                    .filter(horario -> !horario.getHoraSalida().isAfter(horaLlegada))
                    .toList();
            // retornar las listas concatenadas
            List<Horarios> horariosCombinados = new ArrayList<>(horarios1);
            horariosCombinados.addAll(horarios2);
            return horariosCombinados;
        }
        else if (ciudadOrigen.equalsIgnoreCase("esperanza") && ciudadDestino.equalsIgnoreCase("rosario")) {
            Ruta ruta1 = rutaService.getRuta(ciudadOrigen, "Santa Fe");
            Ruta ruta2 = rutaService.getRuta("Santa Fe", ciudadDestino);
            List<Horarios> horarios1 = horariosRepository
                    .findAllByRutaIdAndHoraSalidaGreaterThanEqualAndHoraLlegadaLessThanEqual(ruta1.getId(), horaSalida, horaLlegada)
                    .stream()
                    .filter(horario -> !horario.getHoraSalida().isAfter(horaLlegada))
                    .toList();
            List<Horarios> horarios2 = horariosRepository
                    .findAllByRutaIdAndHoraSalidaGreaterThanEqualAndHoraLlegadaLessThanEqual(ruta2.getId(), horaSalida, horaLlegada)
                    .stream()
                    .filter(horario -> !horario.getHoraSalida().isAfter(horaLlegada))
                    .toList();
            List<Horarios> horariosCombinados = new ArrayList<>(horarios1);
            horariosCombinados.addAll(horarios2);
            return horariosCombinados;
        }
        else {
            Ruta ruta = rutaService.getRuta(ciudadOrigen, ciudadDestino);
            List<Horarios> horarios = horariosRepository
                    .findAllByRutaIdAndHoraSalidaGreaterThanEqualAndHoraLlegadaLessThanEqual(ruta.getId(), horaSalida, horaLlegada);
            return horarios.stream()
                    .filter(horario -> !horario.getHoraSalida().isAfter(horaLlegada))
                    .toList();
        }
    }
}
