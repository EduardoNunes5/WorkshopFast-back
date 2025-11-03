package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.controllers.exceptions.data.ValidationErrorData;
import com.eduardo.workshopfast.dto.collaborator.SaveCollaboratorRequestDto;
import com.eduardo.workshopfast.dto.collaborator.SaveCollaboratorResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface CollaboratorController {

    @Operation(summary = "Cria um novo colaborador no sistema")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Colaborador registrado com sucesso.",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SaveCollaboratorResponseDto.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Algum dado passado foi inválido.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ValidationErrorData.class)),
                    }
            ),
    })
    SaveCollaboratorResponseDto create(SaveCollaboratorRequestDto collaboratorRequestDto);
}
