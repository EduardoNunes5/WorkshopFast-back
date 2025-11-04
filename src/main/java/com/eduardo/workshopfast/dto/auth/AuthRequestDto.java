package com.eduardo.workshopfast.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthRequestDto(
        @NotBlank
        @Size(min = 3)
        @Schema(type = "string", description = "usuário para ser autenticado", example = "matheus", minContains = 3)
        String username,
        @NotBlank
        @Size(min = 3)
        @Schema(type = "string", description = "senha do usuário", example = "1234564", minContains = 3)
        String password
) {
}
