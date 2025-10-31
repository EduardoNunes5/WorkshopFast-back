package com.eduardo.workshopfast.dto.collaborator;

import com.eduardo.workshopfast.dto.workshop.WorkshopDto;
import com.eduardo.workshopfast.entities.Collaborator;
import com.eduardo.workshopfast.entities.WorkshopAttendance;

import java.util.List;

public record CollaboratorDto(
        Long id,
        String name,
        List<WorkshopDto> workshops
) {

    public CollaboratorDto(Collaborator collaborator) {
        this(
                collaborator.getId(),
                collaborator.getName(),
                collaborator.getWorkshops().stream()
                        .map(WorkshopAttendance::getWorkshop)
                        .map(WorkshopDto::new).toList()
        );
    }
}
