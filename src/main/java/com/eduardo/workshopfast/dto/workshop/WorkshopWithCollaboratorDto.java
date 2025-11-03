package com.eduardo.workshopfast.dto.workshop;

import com.eduardo.workshopfast.dto.collaborator.CollaboratorWorkshopAttendanceDto;
import com.eduardo.workshopfast.entities.Workshop;
import com.eduardo.workshopfast.entities.WorkshopAttendance;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record WorkshopWithCollaboratorDto(
        Long id,
        String name,
        String description,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime realizationDate,
        List<CollaboratorWorkshopAttendanceDto> collaborators
) {

    public WorkshopWithCollaboratorDto(Workshop entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getRealizationDate(),
                entity.getWorkshopAttendance() != null ? workshopAttendanceToDto(entity.getWorkshopAttendance()) : List.of()
        );
    }

    private static List<CollaboratorWorkshopAttendanceDto> workshopAttendanceToDto(WorkshopAttendance workshopAttendance) {
        return workshopAttendance.getCollaborators().stream()
                .map((collaborator) -> new CollaboratorWorkshopAttendanceDto(workshopAttendance, collaborator))
                .toList();
    }
}
