package com.eduardo.workshopfast.dto.collaborator;

import com.eduardo.workshopfast.entities.Collaborator;
import com.eduardo.workshopfast.entities.WorkshopAttendance;
import io.swagger.v3.oas.annotations.media.Schema;

public record CollaboratorWorkshopAttendanceDto(@Schema(type = "number", description = "Id do colaborador", example = "5")
                                                Long collaboratorId,
                                                @Schema(type = "number", description = "Id do workshop que o colaborador esteve presente", example = "5")
                                                Long workshopId,
                                                @Schema(type = "string", description = "Nome do colaborador", example = "Roberta")
                                                String collaboratorName,
                                                @Schema(type = "number", description = "Id da ata que o colaborador esteve presente", example = "50")
                                                Long workshopAttendanceId) {

    public CollaboratorWorkshopAttendanceDto(WorkshopAttendance workshopAttendance, Collaborator collaborator) {
        this(
                collaborator.getId(),
                workshopAttendance.getWorkshopId(),
                collaborator.getName(),
                workshopAttendance.getId()
        );
    }

}