package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.dto.collaborator.CollaboratorDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopFilterDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopWithCollaboratorDto;
import com.eduardo.workshopfast.dto.workshop_attendance.*;

import java.util.List;

public interface WorkshopAttendanceService {

    SaveWorkshopAttendanceResponseDto create(SaveWorkshopAttendanceRequestDto workshopAttendanceRequestDto);

    UpdateWorkshopAttendanceResponseDto addCollaborator(Long workshopId, Long workshopAttendanceId, Long collaboratorId);

    void removeCollaborator(Long workshopAttendanceId, Long collaboratorId);

    List<CollaboratorDto> findCollaboratorsAndWorkshopAttendanceSortedByName();

    List<WorkshopWithCollaboratorDto> findWorkshopWithCollaboratorsByFilters(WorkshopFilterDto filter);
}
