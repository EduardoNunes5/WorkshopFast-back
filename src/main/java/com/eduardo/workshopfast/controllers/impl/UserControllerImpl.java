package com.eduardo.workshopfast.controllers.impl;

import com.eduardo.workshopfast.controllers.UserController;
import com.eduardo.workshopfast.dto.user.RegisterUserRequestDto;
import com.eduardo.workshopfast.dto.user.UserDto;
import com.eduardo.workshopfast.entities.enums.RoleValuesEnum;
import com.eduardo.workshopfast.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody RegisterUserRequestDto userRequestDto) {
        return userService.registerUser(userRequestDto, RoleValuesEnum.COLLABORATOR);
    }
}
