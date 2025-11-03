package com.eduardo.workshopfast.dto.workshop;

import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

public record WorkshopFilterDto(
        String collaboratorName,
        LocalDateTime realizationDate,
        String workshopName,
        Sort sort
) {
}
