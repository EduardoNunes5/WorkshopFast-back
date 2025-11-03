package com.eduardo.workshopfast.dto.collaborator;

import com.eduardo.workshopfast.entities.Collaborator;
import io.swagger.v3.oas.annotations.media.Schema;

public record CollaboratorDto(
        @Schema(type = "number", description = "Id do colaborador", example = "5")
        Long id,
        @Schema(type = "string", description = "Nome do colaborador", example = "Júlia")
        String name
) {

    public CollaboratorDto(Collaborator entity) {
        this(
                entity.getId(),
                entity.getName()
        );
    }
}
