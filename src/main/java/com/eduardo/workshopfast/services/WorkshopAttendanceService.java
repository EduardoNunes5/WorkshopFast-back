package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.dto.collaborator.CollaboratorDetailsDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopFilterDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopDetailsDto;
import com.eduardo.workshopfast.dto.workshop_attendance.*;

import java.util.List;

public interface WorkshopAttendanceService {

    SaveWorkshopAttendanceResponseDto create(SaveWorkshopAttendanceRequestDto workshopAttendanceRequestDto);

    AddCollaboratorToWorkshopAttendanceResponseDto addCollaborator(Long workshopId, Long workshopAttendanceId, Long collaboratorId);

    void removeCollaboratorById(Long workshopAttendanceId, Long collaboratorId);

    List<CollaboratorDetailsDto> findCollaboratorsAndWorkshopAttendanceSortedByName();

    List<WorkshopDetailsDto> findWorkshopWithCollaboratorsByFilters(WorkshopFilterDto filter);
}
