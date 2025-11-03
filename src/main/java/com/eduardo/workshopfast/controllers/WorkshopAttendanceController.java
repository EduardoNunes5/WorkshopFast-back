package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.controllers.exceptions.data.ErrorMessage;
import com.eduardo.workshopfast.controllers.exceptions.data.ValidationErrorData;
import com.eduardo.workshopfast.dto.collaborator.CollaboratorDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopSummaryDto;
import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceRequestDto;
import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceResponseDto;
import com.eduardo.workshopfast.dto.workshop_attendance.AddCollaboratorToWorkshopAttendanceRequestDto;
import com.eduardo.workshopfast.dto.workshop_attendance.AddCollaboratorToWorkshopAttendanceResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


import java.time.LocalDateTime;
import java.util.List;

public interface WorkshopAttendanceController {

    @Operation(
            summary = "Cria uma nova ATA para um workshop",
            description = "Nesse sistema, um workshop pode ter várias atas, pois pode ser que haja mais de uma lista de presença para um evento."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "ATA registrada com sucesso.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SaveWorkshopAttendanceResponseDto.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Id de workshop informado nulo.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ValidationErrorData.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Workshop informado não existe",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)),
                    }
            ),
    })
    SaveWorkshopAttendanceResponseDto create(SaveWorkshopAttendanceRequestDto workshopAttendanceRequest);

    @Operation(
            summary = "Adiciona um novo colaborador a uma ATA de presença de um workshop"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Confirmação de presença adicionada com sucesso",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AddCollaboratorToWorkshopAttendanceResponseDto.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Requisição inválida. Pode ocorrer pelo colaborador já estar presente na ATA ou dados faltantes.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema =  @Schema(oneOf = { ErrorMessage.class, ValidationErrorData.class })),
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Workshop, ATA ou colaborador não foram encontrados.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)),
                    }
            ),
    })
    AddCollaboratorToWorkshopAttendanceResponseDto addCollaboratorByWorkshopIdAndWorkshopAttendanceId(Long id, Long workshopAttendanceId, AddCollaboratorToWorkshopAttendanceRequestDto request);

    @Operation(
            summary = "Remove um colaborador de uma ATA de presença de um workshop"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Presença removida com sucesso.",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Requisição inválida. Algum dado faltando ou colaborador não está presente na lista.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema =  @Schema(oneOf = { ValidationErrorData.class, ErrorMessage.class })),
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "ATA ou colaborador não foram encontrados.",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)),
                    }
            ),
    })
    void removeCollaboratorWorkshopAttendanceId(Long id, Long collaboratorId);

    @Operation(
            summary = "Retorna uma lista de todos os colaboradores.",
            description = "Retorna uma lista de todos os colaboradores em ordem alfabética, com informações de workshops que eles já participaram."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de colaboradores com dados de workshops já participados.",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CollaboratorDto.class))
                    }
            ),
    })
    List<CollaboratorDto> findCollaboratorsWithWorkshopAttendanceSortedByName();

    @Operation(
            summary = "Retorna uma lista de workshops filtrados pelo nome.",
            description = "Caso um colaborador esteja presente em mais de uma ATA para um mesmo workshop, aparece na lista de colaboradores mais de uma vez."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista workshops filtrados pelo nome do workshop com os dados dos colaboradores que participaram.",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = WorkshopSummaryDto.class))
                    }
            ),
    })
    List<WorkshopSummaryDto> findWorkshopsWithCollaboratorByWorkshopName(String workshopName);

    @Operation(
            summary = "Retorna uma lista de workshops filtrados pela data de realização.",
            description = "Caso um colaborador esteja presente em mais de uma ATA para um mesmo workshop, aparece na lista de colaboradores mais de uma vez."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista workshops filtrados pela data de realização com os dados dos colaboradores que participaram.",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = WorkshopSummaryDto.class))
                    }
            ),
    })
    List<WorkshopSummaryDto> findWorkshopsWithCollaboratorByRealizationDate(LocalDateTime realizationDate);

    @Operation(
            summary = "Retorna uma lista de workshops filtrados pelo nome do colaborador.",
            description = "Caso um colaborador esteja presente em mais de uma ATA para um mesmo workshop, aparece na lista de colaboradores mais de uma vez."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista workshops filtrados pelo nome do colaborador com os dados dos colaboradores que participaram.",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = WorkshopSummaryDto.class))
                    }
            ),
    })
    List<WorkshopSummaryDto> findWorkshopsWithCollaboratorByCollaboratorName(String collaboratorName);

    @Operation(
            summary = "Retorna uma lista de workshops ordenados pelo nome do workshop.",
            description = "Caso um colaborador esteja presente em mais de uma ATA para um mesmo workshop, ele aparece na lista de colaboradores mais de uma vez."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista workshops ordenados pelo nome do workshop.",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = WorkshopSummaryDto.class))
                    }
            ),
    })
    List<WorkshopSummaryDto> findWorkshopsWithCollaboratorSortedByName();
}
