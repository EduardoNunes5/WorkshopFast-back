package com.eduardo.workshopfast.dto.workshop_attendance;

import com.eduardo.workshopfast.entities.WorkshopAttendance;

public record SaveWorkshopAttendanceResponseDto(
        Long id,
        Long workshopId
) {

    public SaveWorkshopAttendanceResponseDto(WorkshopAttendance workshopAttendance) {
        this(
                workshopAttendance.getId(),
                workshopAttendance.getWorkshopId()
        );
    }
}
