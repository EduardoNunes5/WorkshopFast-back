package com.eduardo.workshopfast.dto.workshop;

import com.eduardo.workshopfast.entities.Workshop;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record WorkshopDto(
        Long id,
        String name,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime realizationDate,
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
