package com.alura.foro.repository;

import com.alura.foro.domain.modelo.Respuesta;
import com.alura.foro.domain.modelo.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta,Long> {
    Page<Respuesta> findByActivoTrue(Pageable pageable);
    Page<Respuesta> findByTopicoIdAndActivoTrue(Pageable pageable, Long id);
}
