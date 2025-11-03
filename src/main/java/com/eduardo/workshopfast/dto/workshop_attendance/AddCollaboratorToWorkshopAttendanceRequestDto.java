package com.eduardo.workshopfast.dto.workshop_attendance;

import jakarta.validation.constraints.NotNull;

public record AddCollaboratorToWorkshopAttendanceRequestDto(
        @NotNull(message = "collaborator id must be informed")
        Long collaboratorId) {
}
