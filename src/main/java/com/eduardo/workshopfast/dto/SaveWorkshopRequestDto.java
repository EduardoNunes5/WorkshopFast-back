package com.eduardo.workshopfast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record SaveWorkshopRequestDto(
        @NotEmpty(message = "Workshop name cannot be empty")
        String name,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime realizationDate,
        String description
) {
}
