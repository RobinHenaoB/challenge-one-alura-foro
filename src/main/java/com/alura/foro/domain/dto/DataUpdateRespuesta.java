package com.alura.foro.domain.dto;

import jakarta.validation.constraints.NotNull;

public record DataUpdateRespuesta(
        @NotNull
        Long id,
        String mensaje) {

}
