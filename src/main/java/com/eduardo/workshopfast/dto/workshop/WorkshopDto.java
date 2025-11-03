package com.eduardo.workshopfast.dto.workshop;

import com.eduardo.workshopfast.entities.Workshop;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record WorkshopDto(
        @Schema(type = "number", description = "Id do workshop", example = "1")
        Long id,
        @Schema(type = "string", description = "Nome do workshop", example = "APIS com Python - Introdução")
        String name,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        @Schema(type = "string", description = "Data do workshop", example = "12/12/2025 20:00:00")
        LocalDateTime realizationDate,
        @Schema(type = "string", description = "Descrição do workshop", example = "Crie APIS robustas com Python")
        String description
) {

    public WorkshopDto(Workshop entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getRealizationDate(),
                entity.getDescription()
        );
    }
}
