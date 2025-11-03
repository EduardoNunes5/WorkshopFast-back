package com.eduardo.workshopfast.dto.collaborator;

import com.eduardo.workshopfast.dto.workshop_attendance.WorkshopAttendanceSummaryDto;
import com.eduardo.workshopfast.entities.Collaborator;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record CollaboratorDetailsDto(
        @Schema(type = "number", description = "Id do colaborador", example = "5")
        Long id,
        @Schema(type = "string", description = "Nome do colaborador", example = "Pedro")
        String name,
        @Schema(type = "object", description = "Workshops em que o colaborador esteve presente", implementation = WorkshopAttendanceSummaryDto.class)
        List<WorkshopAttendanceSummaryDto> workshops
) {

    public CollaboratorDetailsDto(Collaborator collaborator) {
        this(
                collaborator.getId(),
                collaborator.getName(),
                collaborator.getWorkshops().stream()
                        .map(workshopAttendance -> new WorkshopAttendanceSummaryDto(workshopAttendance.getWorkshop(), workshopAttendance.getId()))
                        .toList()
        );
    }
}
