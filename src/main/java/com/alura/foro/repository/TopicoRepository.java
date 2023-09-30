package com.alura.foro.repository;


import com.alura.foro.domain.modelo.Topico;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    Boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Page<Topico> findByActivoTrue(Pageable pageable);
}
