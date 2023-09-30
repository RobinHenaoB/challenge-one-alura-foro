package com.alura.foro.domain.dto;

import com.alura.foro.domain.modelo.StatusTopico;
import com.alura.foro.domain.modelo.Topico;

import java.time.LocalDateTime;

public record DataResponceTopico(Long id, String title, String message, LocalDateTime creationDate, StatusTopico status, String author, String course) {
    public DataResponceTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatusTopico(),
                topico.getAuthor().getNombre(),
                topico.getCurso().getNombre());

    }
}


