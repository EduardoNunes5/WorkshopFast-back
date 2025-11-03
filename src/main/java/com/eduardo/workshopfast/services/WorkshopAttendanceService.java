package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.dto.collaborator.CollaboratorDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopFilterDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopSummaryDto;
import com.eduardo.workshopfast.dto.workshop_attendance.*;

import java.util.List;

public interface WorkshopAttendanceService {

    SaveWorkshopAttendanceResponseDto create(SaveWorkshopAttendanceRequestDto workshopAttendanceRequestDto);

    AddCollaboratorToWorkshopAttendanceResponseDto addCollaborator(Long workshopId, Long workshopAttendanceId, Long collaboratorId);

    void removeCollaboratorById(Long workshopAttendanceId, Long collaboratorId);

    List<CollaboratorDto> findCollaboratorsAndWorkshopAttendanceSortedByName();

    List<WorkshopSummaryDto> findWorkshopWithCollaboratorsByFilters(WorkshopFilterDto filter);
}
