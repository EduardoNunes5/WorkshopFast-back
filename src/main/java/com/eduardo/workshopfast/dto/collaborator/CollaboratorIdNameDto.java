package com.eduardo.workshopfast.dto.collaborator;

import com.eduardo.workshopfast.entities.Collaborator;

public record CollaboratorIdNameDto(
        Long id,
        String name
) {

    public CollaboratorIdNameDto(Collaborator entity) {
        this(entity.getId(), entity.getName());
    }
}
