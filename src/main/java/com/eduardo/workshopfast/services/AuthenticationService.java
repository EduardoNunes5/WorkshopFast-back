package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.dto.auth.AuthRequestDto;
import com.eduardo.workshopfast.dto.auth.AuthResponseDto;

public interface AuthenticationService {

    AuthResponseDto authenticate(AuthRequestDto requestDto);
}
