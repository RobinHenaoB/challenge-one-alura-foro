package com.alura.foro.domain.dto;

import com.alura.foro.domain.modelo.StatusTopico;
import com.alura.foro.domain.modelo.Topico;

import java.time.LocalDateTime;

public record DataListTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechasCreacion,
        StatusTopico statusTopico,
        String author,
        String curso) {

    public DataListTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatusTopico(),
                topico.getAuthor().getNombre(),
                topico.getCurso().getNombre());
    }
}