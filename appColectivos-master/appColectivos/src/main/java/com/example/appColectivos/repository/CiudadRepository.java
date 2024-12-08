package com.example.appColectivos.repository;

import com.example.appColectivos.domain.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
