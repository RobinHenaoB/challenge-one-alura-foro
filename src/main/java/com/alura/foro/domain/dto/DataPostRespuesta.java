package com.alura.foro.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record DataPostRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Long topico,
        @NotNull
        Long author) {

}
