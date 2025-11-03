package com.eduardo.workshopfast.dto.workshop_attendance;

import com.eduardo.workshopfast.dto.workshop.WorkshopDto;
import com.eduardo.workshopfast.entities.Workshop;
import io.swagger.v3.oas.annotations.media.Schema;


public record WorkshopAttendanceSummaryDto(WorkshopDto workshop,
                                           @Schema(type = "number", description = "Id da ATA de presença", example = "1")
                                           Long workshopAttendanceId) {

    public WorkshopAttendanceSummaryDto(Workshop workshop, Long workshopAttendanceId) {
        this(
                new WorkshopDto(workshop),
                workshopAttendanceId
        );
    }
}
