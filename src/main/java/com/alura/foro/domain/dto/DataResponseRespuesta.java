package com.alura.foro.domain.dto;

import com.alura.foro.domain.modelo.Respuesta;

import java.time.LocalDateTime;

public record DataResponseRespuesta(Long id,
                                    String mensaje,
                                    String topico,
                                    LocalDateTime fechaCreacion,
                                    String author,
                                    Boolean solucion) {

    public DataResponseRespuesta(Respuesta response) {
        this(response.getId(),
                response.getMensaje(),
                response.getTopico().getTitulo(),
                response.getFechaCreacion(),
                response.getAuthor().getNombre(),
                response.getSolucion());
    }

}
