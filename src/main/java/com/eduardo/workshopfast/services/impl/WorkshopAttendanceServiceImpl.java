package com.eduardo.workshopfast.services.impl;

import com.eduardo.workshopfast.dto.collaborator.CollaboratorDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopFilterDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopWithCollaboratorDto;
import com.eduardo.workshopfast.dto.workshop_attendance.*;
import com.eduardo.workshopfast.entities.Collaborator;
import com.eduardo.workshopfast.entities.Workshop;
import com.eduardo.workshopfast.entities.WorkshopAttendance;
import com.eduardo.workshopfast.exceptions.ResourceAlreadyExistsException;
import com.eduardo.workshopfast.exceptions.ResourceNotFoundException;
import com.eduardo.workshopfast.repositories.WorkshopAttendanceRepository;
import com.eduardo.workshopfast.services.CollaboratorService;
import com.eduardo.workshopfast.services.WorkshopAttendanceService;
import com.eduardo.workshopfast.services.WorkshopService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
class WorkshopAttendanceServiceImpl implements WorkshopAttendanceService {

    private final WorkshopAttendanceRepository repository;
    private final WorkshopService workshopService;
    private final CollaboratorService collaboratorService;

    public WorkshopAttendanceServiceImpl(WorkshopAttendanceRepository repository, WorkshopService workshopService, CollaboratorService collaboratorService) {
        this.repository = repository;
        this.workshopService = workshopService;
        this.collaboratorService = collaboratorService;
    }

    @Override
    @Transactional
    public SaveWorkshopAttendanceResponseDto create(SaveWorkshopAttendanceRequestDto workshopAttendanceRequestDto) {
        if(repository.existsByWorkshopId(workshopAttendanceRequestDto.workshopId())) {
            throw new ResourceAlreadyExistsException(String.format("An attendance list already exists for the workshop with id: %d", workshopAttendanceRequestDto.workshopId()));
        }

        try {
            Workshop workshop = workshopService.getReferenceById(workshopAttendanceRequestDto.workshopId());
            WorkshopAttendance newWorkshopAttendance = new WorkshopAttendance(workshop);
            newWorkshopAttendance = repository.save(newWorkshopAttendance);
            return new SaveWorkshopAttendanceResponseDto(newWorkshopAttendance);
        } catch (DataIntegrityViolationException notFound) {
            throw new ResourceNotFoundException(String.format("Workshop with id: %d not found", workshopAttendanceRequestDto.workshopId()));
        }
    }

    @Override
    @Transactional
    public UpdateWorkshopAttendanceResponseDto addCollaborator(Long workshopId, Long workshopAttendanceId, Long collaboratorId) {
        WorkshopAttendance workshopAttendance = repository.findByIdAndWorkshopId(workshopAttendanceId, workshopId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Workshop attendance list with id: %d from workshop id: %d not found", workshopAttendanceId, workshopId)));

        if(repository.existsCollaboratorInWorkshopAttendance(workshopAttendanceId, collaboratorId)) {
            throw new ResourceAlreadyExistsException(String.format("Collaborator with id: %d already present in workshop attendance", collaboratorId));
        }

        Collaborator collaborator = collaboratorService.findById(collaboratorId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Collaborator with id: %d does not exist", collaboratorId)));

        workshopAttendance.addCollaborator(collaborator);

        return new UpdateWorkshopAttendanceResponseDto(workshopAttendanceId, workshopId, collaboratorId);
    }

    @Override
    @Transactional
    public void removeCollaborator(Long workshopAttendanceId, Long collaboratorId) {
        WorkshopAttendance workshopAttendance = repository.findById(workshopAttendanceId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Workshop attendance list with id: %d not found", workshopAttendanceId)));

        if(!repository.existsCollaboratorInWorkshopAttendance(workshopAttendanceId, collaboratorId)) {
            throw new ResourceNotFoundException(String.format("Collaborator with id: %d not found or not present in workshop", collaboratorId));
        }

        Collaborator collaborator = collaboratorService.getReferenceById(collaboratorId);

        workshopAttendance.removeCollaborator(collaborator);
    }

    @Override
    public List<CollaboratorDto> findCollaboratorsAndWorkshopAttendanceSortedByName() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        final List<Collaborator> collaborators =  collaboratorService.findAllSortedWithRelatedData(sort);
        return collaborators.stream().map(CollaboratorDto::new).toList();
    }

    @Override
    public List<WorkshopWithCollaboratorDto> findWorkshopWithCollaboratorsByFilters(WorkshopFilterDto filter) {
        List<Workshop> workshops = workshopService.findByFilters(filter);
        return workshops.stream().map(WorkshopWithCollaboratorDto::new).toList();
    }
}
