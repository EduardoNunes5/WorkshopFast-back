package com.eduardo.workshopfast.dto.collaborator;

import com.eduardo.workshopfast.dto.workshop.WorkshopDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopWithAttendanceIdDto;
import com.eduardo.workshopfast.entities.Collaborator;
import com.eduardo.workshopfast.entities.WorkshopAttendance;

import java.util.List;

public record CollaboratorDto(
        Long id,
        String name,
        List<WorkshopWithAttendanceIdDto> workshops
) {

    public CollaboratorDto(Collaborator collaborator) {
        this(
                collaborator.getId(),
                collaborator.getName(),
                collaborator.getWorkshops().stream()
                        .map(workshopAttendance -> new WorkshopWithAttendanceIdDto(workshopAttendance.getWorkshop(), workshopAttendance.getId()))
                        .toList()
        );
    }
}
