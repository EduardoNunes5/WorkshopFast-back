package com.eduardo.workshopfast.services.impl;

import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceRequestDto;
import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceResponseDto;
import com.eduardo.workshopfast.entities.Workshop;
import com.eduardo.workshopfast.entities.WorkshopAttendance;
import com.eduardo.workshopfast.exceptions.ResourceAlreadyExistsException;
import com.eduardo.workshopfast.exceptions.ResourceNotFoundException;
import com.eduardo.workshopfast.repositories.WorkshopAttendanceRepository;
import com.eduardo.workshopfast.services.WorkshopAttendanceService;
import com.eduardo.workshopfast.services.WorkshopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class WorkshopAttendanceServiceImpl implements WorkshopAttendanceService {

    private final WorkshopAttendanceRepository repository;
    private final WorkshopService workshopService;

    public WorkshopAttendanceServiceImpl(WorkshopAttendanceRepository repository, WorkshopService workshopService) {
        this.repository = repository;
        this.workshopService = workshopService;
    }

    @Override
    @Transactional
    public SaveWorkshopAttendanceResponseDto create(SaveWorkshopAttendanceRequestDto workshopAttendanceRequestDto) {
        if(repository.existsByWorkshop_id(workshopAttendanceRequestDto.workshopId())) {
            throw new ResourceAlreadyExistsException(String.format("An attendance list already exists for the workshop with id: %d", workshopAttendanceRequestDto.workshopId()));
        }

        try {
            Workshop workshop = workshopService.getReferenceById(workshopAttendanceRequestDto.workshopId());
            WorkshopAttendance newWorkshopAttendance = new WorkshopAttendance(workshop);
            newWorkshopAttendance = repository.save(newWorkshopAttendance);
            return new SaveWorkshopAttendanceResponseDto(newWorkshopAttendance);
        } catch (Exception notFound) {
            System.out.println("Caí aqui");
            throw new ResourceNotFoundException(String.format("Workshop with id: %d not found", workshopAttendanceRequestDto.workshopId()));
        }
    }
}
