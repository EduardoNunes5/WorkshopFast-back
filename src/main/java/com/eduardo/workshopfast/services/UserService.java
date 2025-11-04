package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.dto.user.RegisterUserRequestDto;
import com.eduardo.workshopfast.dto.user.UserDto;
import com.eduardo.workshopfast.entities.User;
import com.eduardo.workshopfast.entities.enums.RoleValuesEnum;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    UserDto registerUser(RegisterUserRequestDto requestDto, RoleValuesEnum roleValuesEnum);
}
