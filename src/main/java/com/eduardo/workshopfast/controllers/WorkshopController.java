package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.controllers.exceptions.data.ValidationErrorData;
import com.eduardo.workshopfast.dto.workshop.SaveWorkshopRequestDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


public interface WorkshopController {

    @Operation(summary = "Cria um novo workshop no sistema.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Workshop criado com sucesso.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = WorkshopDto.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Workshop possui algum dado inválido.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ValidationErrorData.class)),
                    }
            ),
    })
    WorkshopDto createWorkshop(SaveWorkshopRequestDto workshopRequestDto);
}
