package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.dto.user.RegisterUserRequestDto;
import com.eduardo.workshopfast.dto.user.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface UserController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserDto createUser(RegisterUserRequestDto userRequestDto);
}
