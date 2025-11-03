package com.eduardo.workshopfast.dto.collaborator;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record SaveCollaboratorRequestDto(
        @NotBlank(message = "Collaborator name must be specified")
        @Schema(type = "string", description = "Nome do colaborador a ser registrado", example = "Roberto")
        String name
) {
}
