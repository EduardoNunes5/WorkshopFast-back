package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.controllers.exceptions.data.ErrorMessage;
import com.eduardo.workshopfast.controllers.exceptions.data.ValidationErrorData;
import com.eduardo.workshopfast.dto.auth.AuthRequestDto;
import com.eduardo.workshopfast.dto.auth.AuthResponseDto;
import com.eduardo.workshopfast.dto.collaborator.CollaboratorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface AuthenticationController {

    @Operation(
            summary = "Efetua Login no sistema",
            description = "Por padrão, cada token dura 600 segundos (10 minutos)"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuario autenticado com sucesso.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AuthResponseDto.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário ou senha inválidos",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)),
                    }
            ),
    })
    AuthResponseDto login( AuthRequestDto requestDto);
}
