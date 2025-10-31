package com.eduardo.workshopfast.dto.collaborator;

import com.eduardo.workshopfast.entities.Collaborator;

public record SaveCollaboratorResponseDto(
        Long id,
        String name
) {

    public SaveCollaboratorResponseDto(Collaborator entity) {
        this(
                entity.getId(),
                entity.getName()
        );
    }
}
