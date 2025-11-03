package com.eduardo.workshopfast.dto.workshop;

import com.eduardo.workshopfast.entities.Workshop;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record WorkshopWithAttendanceIdDto(Long id,
                                          String name,
                                          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
                                          LocalDateTime realizationDate,
                                          String description,
                                          Long workshopAttendanceId) {

    public WorkshopWithAttendanceIdDto(Workshop workshop, Long workshopAttendanceId) {
        this(
                workshop.getId(),
                workshop.getName(),
                workshop.getRealizationDate(),
                workshop.getDescription(),
                workshopAttendanceId
        );
    }
}
