package com.eduardo.workshopfast.dto.collaborator;

import com.eduardo.workshopfast.dto.workshop_attendance.WorkshopAttendanceSummaryDto;
import com.eduardo.workshopfast.entities.Collaborator;

import java.util.List;

public record CollaboratorDto(
        Long id,
        String name,
        List<WorkshopAttendanceSummaryDto> workshops
) {

    public CollaboratorDto(Collaborator collaborator) {
        this(
                collaborator.getId(),
                collaborator.getName(),
                collaborator.getWorkshops().stream()
                        .map(workshopAttendance -> new WorkshopAttendanceSummaryDto(workshopAttendance.getWorkshop(), workshopAttendance.getId()))
                        .toList()
        );
    }
}
