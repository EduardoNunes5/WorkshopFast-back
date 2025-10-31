package com.eduardo.workshopfast.dto.workshop;

import java.time.LocalDateTime;

public record WorkshopFilterDto(
        String collaboratorName,
        LocalDateTime realizationDate,
        String workshopName
) {
}
