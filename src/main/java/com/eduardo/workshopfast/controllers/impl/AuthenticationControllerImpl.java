package com.eduardo.workshopfast.controllers.impl;

import com.eduardo.workshopfast.controllers.AuthenticationController;
import com.eduardo.workshopfast.dto.auth.AuthRequestDto;
import com.eduardo.workshopfast.dto.auth.AuthResponseDto;
import com.eduardo.workshopfast.services.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationControllerImpl(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }
}
