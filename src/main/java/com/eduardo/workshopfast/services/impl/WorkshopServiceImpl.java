package com.eduardo.workshopfast.services.impl;

import com.eduardo.workshopfast.dto.workshop.SaveWorkshopRequestDto;
import com.eduardo.workshopfast.dto.workshop.SaveWorkshopResponseDto;
import com.eduardo.workshopfast.entities.Workshop;
import com.eduardo.workshopfast.repositories.WorkshopRepository;
import com.eduardo.workshopfast.services.WorkshopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopRepository repository;

    WorkshopServiceImpl(WorkshopRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public SaveWorkshopResponseDto create(SaveWorkshopRequestDto requestDto) {
        Workshop newWorkshop = new Workshop(requestDto.name(), requestDto.realizationDate(), requestDto.description());
        newWorkshop = repository.save(newWorkshop);
        return new SaveWorkshopResponseDto(newWorkshop);
    }

    @Override
    public Workshop getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }
}
