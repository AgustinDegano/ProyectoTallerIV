package com.example.appColectivos.repository;

import com.example.appColectivos.domain.Ciudad;
import com.example.appColectivos.domain.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {
    Ruta findByCiudadOrigen_NombreAndCiudadDestino_Nombre(String ciudadOrigen, String ciudadDestino);
}
