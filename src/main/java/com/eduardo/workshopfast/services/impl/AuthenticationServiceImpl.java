package com.eduardo.workshopfast.services.impl;

import com.eduardo.workshopfast.dto.auth.AuthRequestDto;
import com.eduardo.workshopfast.dto.auth.AuthResponseDto;
import com.eduardo.workshopfast.entities.Role;
import com.eduardo.workshopfast.entities.User;
import com.eduardo.workshopfast.exceptions.ResourceNotFoundException;
import com.eduardo.workshopfast.services.AuthenticationService;
import com.eduardo.workshopfast.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class AuthenticationServiceImpl implements AuthenticationService {

    private static final String ROLES_JOIN_DELIMITER = " ";
    private static final String JWT_ISSUER = "Fast-solucoes";

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    AuthenticationServiceImpl(UserService userService, PasswordEncoder passwordEncoder, JwtEncoder jwtEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtEncoder = jwtEncoder;
    }

    @Override
    public AuthResponseDto authenticate(AuthRequestDto requestDto) {
        final Optional<User> user = userService.findByUsername(requestDto.username());

        if(user.isEmpty() || !user.get().passwordMatches(requestDto.password(), passwordEncoder)) {
            throw new ResourceNotFoundException("Username or password invalid");
        }

        var now = Instant.now();
        var expiresIn = 600L;

        var scopes = user.get().getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.joining(ROLES_JOIN_DELIMITER));

        var claims = JwtClaimsSet.builder()
                .issuer(JWT_ISSUER)
                .subject(user.get().getId().toString())
                .expiresAt(now.plusSeconds(expiresIn))
                .issuedAt(now)
                .claim("scope", scopes)
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return new AuthResponseDto(jwtValue, expiresIn);
    }
}
