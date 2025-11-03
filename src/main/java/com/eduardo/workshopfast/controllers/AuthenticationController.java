package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.dto.auth.AuthRequestDto;
import com.eduardo.workshopfast.dto.auth.AuthResponseDto;

public interface AuthenticationController {
    AuthResponseDto login( AuthRequestDto requestDto);
}
