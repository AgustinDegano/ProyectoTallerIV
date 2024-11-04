package com.example.appColectivos.repository;

import com.example.appColectivos.domain.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface HorariosRepository extends JpaRepository<Horarios, Long> {
    List<Horarios> findAllByRutaIdAndHoraSalidaGreaterThanEqualAndHoraLlegadaLessThanEqual(Long ruta_id, LocalTime horaSalida, LocalTime horaLlegada);
}
