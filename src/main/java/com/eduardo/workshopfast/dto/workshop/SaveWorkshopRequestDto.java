package com.eduardo.workshopfast.dto.workshop;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record SaveWorkshopRequestDto(
        @NotBlank(message = "Workshop name cannot be empty")
        @Schema(type = "string", description = "Nome do workshop", example = "Workshop para criação de rest apis em java.")
        String name,

        @Schema(type = "string", description = "Data do workshop", example = "11/12/2025 10:20:00", pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime realizationDate,

        @Schema(type = "string", description = "Descrição do workshop", example = "Você aprenderá do zero como construir apis, documentar e desenvolver testes unitários utilizando JUnit 5.x e Mockito!")
        String description
) {
}
