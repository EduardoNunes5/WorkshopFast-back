package com.eduardo.workshopfast.services.impl;

import com.eduardo.workshopfast.dto.workshop.SaveWorkshopRequestDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopFilterDto;
import com.eduardo.workshopfast.entities.Workshop;
import com.eduardo.workshopfast.repositories.WorkshopRepository;
import com.eduardo.workshopfast.services.WorkshopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopRepository repository;

    WorkshopServiceImpl(WorkshopRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public WorkshopDto create(SaveWorkshopRequestDto requestDto) {
        Workshop newWorkshop = new Workshop(requestDto.name(), requestDto.realizationDate(), requestDto.description());
        newWorkshop = repository.save(newWorkshop);
        return new WorkshopDto(newWorkshop);
    }

    @Override
    public Workshop getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Workshop> findByFilters(WorkshopFilterDto filter) {
        return repository.findByCollaboratorNameAndRealizationDateAndWorkshopName(filter.collaboratorName(), filter.realizationDate(), filter.workshopName());
    }
}
