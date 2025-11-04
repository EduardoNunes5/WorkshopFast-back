package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.controllers.exceptions.data.ErrorMessage;
import com.eduardo.workshopfast.controllers.exceptions.data.ValidationErrorData;
import com.eduardo.workshopfast.dto.auth.AuthResponseDto;
import com.eduardo.workshopfast.dto.user.RegisterUserRequestDto;
import com.eduardo.workshopfast.dto.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface UserController {

    @Operation(
            summary = "Registra um usuário no sistema",
            description = "Por padrão, o usuário registrado é de nível COLABORADOR"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Usuario registrado com sucesso.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados passados inválidos ou usuário já existe",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(oneOf = {ValidationErrorData.class, ErrorMessage.class})),
                    }
            ),
    })
    UserDto createUser(RegisterUserRequestDto userRequestDto);
}
