package com.eduardo.workshopfast.dto.workshop_attendance;

import jakarta.validation.constraints.NotNull;

public record SaveWorkshopAttendanceRequestDto(
        @NotNull(message = "Workshop id must not be null")
        Long workshopId
) {
}
