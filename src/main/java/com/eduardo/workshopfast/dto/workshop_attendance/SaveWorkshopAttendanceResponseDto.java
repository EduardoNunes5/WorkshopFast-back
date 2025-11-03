package com.eduardo.workshopfast.dto.workshop_attendance;

import com.eduardo.workshopfast.entities.WorkshopAttendance;
import io.swagger.v3.oas.annotations.media.Schema;

public record SaveWorkshopAttendanceResponseDto(
        @Schema(type = "number", description = "Id da ATA de presença", example = "1")
        Long id,
        @Schema(type = "number", description = "Id do workshop", example = "6")
        Long workshopId
) {

    public SaveWorkshopAttendanceResponseDto(WorkshopAttendance workshopAttendance) {
        this(
                workshopAttendance.getId(),
                workshopAttendance.getWorkshopId()
        );
    }
}
