package com.eduardo.workshopfast.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequestDto(
        @NotBlank
        @Size(min = 2)
        @Schema(type = "string", description = "nome do usuário para ser autenticado posteriormente", example = "larissa", minContains = 3)
        String username,
        @NotBlank
        @Size(min = 3)
        @Schema(type = "string", description = "senha do usuário para ser autenticado posteriormente", example = "123456", minContains = 3)
        String password
) {
}
