package com.alura.foro.domain.dto;

import com.alura.foro.domain.modelo.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record DataUpdateTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        StatusTopico statusTopico,
        Long curso) {
}
