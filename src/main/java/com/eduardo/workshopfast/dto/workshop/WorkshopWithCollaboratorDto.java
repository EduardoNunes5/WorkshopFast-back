package com.eduardo.workshopfast.dto.workshop;

import com.eduardo.workshopfast.dto.collaborator.CollaboratorIdNameDto;
import com.eduardo.workshopfast.entities.Workshop;

import java.util.List;

public record WorkshopWithCollaboratorDto(
        Long id,
        String name,
        String description,
        List<CollaboratorIdNameDto> collaborators
) {

    public WorkshopWithCollaboratorDto(Workshop entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getWorkshopAttendance() != null ? entity.getWorkshopAttendance().getCollaborators().stream().map(CollaboratorIdNameDto::new).toList() : List.of()
        );
    }
}
