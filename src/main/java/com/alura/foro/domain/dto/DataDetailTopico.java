package com.alura.foro.domain.dto;

import com.alura.foro.domain.modelo.StatusTopico;

import java.time.LocalDateTime;
import java.util.List;

public record DataDetailTopico(Long id,
                               String titulo,
                               String mensaje,
                               LocalDateTime fechaCreacion,
                               StatusTopico statusTopico,
                               String nombre, String nombre1,
                               List<DataListRespuesta> content
) {
}
