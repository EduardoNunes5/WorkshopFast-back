package com.eduardo.workshopfast.dto.workshop_attendance;

public record UpdateWorkshopAttendanceResponseDto(
        Long id,
        Long workshopId,
        Long collaboratorId
) {
}
