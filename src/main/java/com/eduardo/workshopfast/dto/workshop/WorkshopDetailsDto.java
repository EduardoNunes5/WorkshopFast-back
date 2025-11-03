package com.eduardo.workshopfast.dto.workshop;

import com.eduardo.workshopfast.dto.collaborator.CollaboratorWorkshopAttendanceDto;
import com.eduardo.workshopfast.entities.Workshop;
import com.eduardo.workshopfast.entities.WorkshopAttendance;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

public record WorkshopDetailsDto(
        @Schema(type = "number", description = "Id do workshop", example = "5")
        Long id,
        @Schema(type = "string", description = "Nome do workshop", example = "APIS com Python - Introdução")
        String name,
        @Schema(type = "string", description = "Descrição do workshop", example = "Crie APIS robustas com Python")
        String description,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        @Schema(type = "string", description = "Data do workshop", example = "20/05/2025 15:30")
        LocalDateTime realizationDate,

        @Schema(type = "object", description = "Colaboradores presentes no workshop", implementation = CollaboratorWorkshopAttendanceDto.class)
        List<CollaboratorWorkshopAttendanceDto> collaborators
) {

    public WorkshopDetailsDto(Workshop entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getRealizationDate(),
                entity.getWorkshopAttendances() != null ? workshopAttendanceToDto(entity.getWorkshopAttendances()) : List.of()
        );
    }

    private static List<CollaboratorWorkshopAttendanceDto> workshopAttendanceToDto(List<WorkshopAttendance> workshopAttendances) {
        // achatando as listas de presença do workshop para poder retornar uma lista de colaboradores associados a cada uma delas
        return workshopAttendances.stream()
                .flatMap(attendance ->
                        attendance.getCollaborators().stream()
                                .map(collaborator -> new CollaboratorWorkshopAttendanceDto(attendance, collaborator))
                )
                .toList();
    }
}
