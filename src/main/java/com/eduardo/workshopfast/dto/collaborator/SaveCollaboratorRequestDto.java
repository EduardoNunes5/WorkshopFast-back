package com.eduardo.workshopfast.dto.collaborator;

import jakarta.validation.constraints.NotBlank;

public record SaveCollaboratorRequestDto(
        @NotBlank(message = "Collaborator name must be specified")
        String name
) {
}
