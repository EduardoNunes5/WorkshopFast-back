package com.eduardo.workshopfast.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
public record AuthResponseDto(
        @Schema(type = "string", description = "token criptografado do usuário", example = "mpjiwejgpftiamejgf-akeio-tak")
        String accessToken,
        @Schema(type = "string", description = "expiração do token em segundos", example = "matheus", defaultValue = "600")
        Long expiresInSeconds) {
}
