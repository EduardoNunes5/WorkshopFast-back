package com.eduardo.workshopfast.services.impl;

import com.eduardo.workshopfast.dto.user.RegisterUserRequestDto;
import com.eduardo.workshopfast.dto.user.UserDto;
import com.eduardo.workshopfast.entities.Role;
import com.eduardo.workshopfast.entities.User;
import com.eduardo.workshopfast.entities.enums.RoleValuesEnum;
import com.eduardo.workshopfast.exceptions.ResourceAlreadyExistsException;
import com.eduardo.workshopfast.repositories.RoleRepository;
import com.eduardo.workshopfast.repositories.UserRepository;
import com.eduardo.workshopfast.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDto registerUser(RegisterUserRequestDto requestDto, RoleValuesEnum roleValuesEnum) {
        findByUsername(requestDto.username())
                .ifPresent((user) -> {
                    throw new ResourceAlreadyExistsException("User already exists");
                });

        String encodedPassword = passwordEncoder.encode(requestDto.password());
        Role role = roleRepository.findByName(roleValuesEnum.name());
        User newUser = new User(requestDto.username(), encodedPassword);
        newUser.setRoles(Set.of(role));

        newUser = userRepository.save(newUser);
        return new UserDto(newUser.getId(), newUser.getPassword());
    }
}
