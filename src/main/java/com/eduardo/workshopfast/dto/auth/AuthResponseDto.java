package com.eduardo.workshopfast.dto.auth;

public record AuthResponseDto(String accessToken, Long expiresInSeconds) {
}
