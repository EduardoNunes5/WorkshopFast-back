package com.eduardo.workshopfast.dto.collaborator;

import com.eduardo.workshopfast.entities.Collaborator;
import com.eduardo.workshopfast.entities.WorkshopAttendance;

public record CollaboratorWorkshopAttendanceDto(Long collaboratorId,
                                                Long workshopId,
                                                String collaboratorName,
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