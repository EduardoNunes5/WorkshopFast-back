package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.dto.collaborator.CollaboratorDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopWithCollaboratorDto;
import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceRequestDto;
import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceResponseDto;
import com.eduardo.workshopfast.dto.workshop_attendance.UpdateWorkshopAttendanceRequestDto;
import com.eduardo.workshopfast.dto.workshop_attendance.UpdateWorkshopAttendanceResponseDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkshopAttendanceController {

    SaveWorkshopAttendanceResponseDto create(SaveWorkshopAttendanceRequestDto workshopAttendanceRequest);

    UpdateWorkshopAttendanceResponseDto addCollaborator(Long id, Long workshopAttendanceId, UpdateWorkshopAttendanceRequestDto request);

    void removeCollaborator(Long id, Long collaboratorId);

    List<CollaboratorDto> findCollaboratorsWithWorkshopAttendanceSortedByName();

    List<WorkshopWithCollaboratorDto> findWorkshopsWithCollaboratorByWorkshopName(String workshopName);

    List<WorkshopWithCollaboratorDto> findWorkshopsWithCollaboratorByRealizationDate(LocalDateTime realizationDate);

    List<WorkshopWithCollaboratorDto> findWorkshopsWithCollaboratorByCollaboratorName(String collaboratorName);

    List<WorkshopWithCollaboratorDto> findWorkshopsWithCollaboratorBySortedByName();
}
