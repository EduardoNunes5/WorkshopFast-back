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

    @Operation(summary = "Creates a new collaborator")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Collaborator registered successfully",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SaveCollaboratorResponseDto.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid data has been passed.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ValidationErrorData.class)),
                    }
            ),
    })
    SaveCollaboratorResponseDto create(SaveCollaboratorRequestDto collaboratorRequestDto);
}
