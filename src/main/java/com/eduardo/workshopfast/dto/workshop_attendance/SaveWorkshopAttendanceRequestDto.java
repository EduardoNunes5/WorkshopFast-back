package com.eduardo.workshopfast.dto.workshop_attendance;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record SaveWorkshopAttendanceRequestDto(
        @NotNull(message = "Workshop id must not be null")
        @Schema(type = "number", description = "Id do workshop a ter uma nova ATA de presença", example = "1")
        Long workshopId
) {
}
