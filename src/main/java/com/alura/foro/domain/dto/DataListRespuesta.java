package com.alura.foro.domain.dto;

import com.alura.foro.domain.modelo.Respuesta;

import java.time.LocalDateTime;

public record DataListRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        String author,
        Boolean solucion
){
        public DataListRespuesta(Respuesta respuesta) {
                this(respuesta.getId(),
                        respuesta.getMensaje(),
                        respuesta.getFechaCreacion(),
                        respuesta.getAuthor().getNombre(),
                        respuesta.getSolucion());
        }

}
