package com.eduardo.workshopfast.dto.workshop_attendance;

import io.swagger.v3.oas.annotations.media.Schema;

public record AddCollaboratorToWorkshopAttendanceResponseDto(
        @Schema(type = "number", description = "Id da ATA de presença", example = "1")
        Long id,
        @Schema(type = "number", description = "Id do workshop", example = "2")
        Long workshopId,
        @Schema(type = "number", description = "Id do colaborador", example = "3")
        Long collaboratorId
) {
}
