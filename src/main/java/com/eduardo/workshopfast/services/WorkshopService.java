package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.dto.workshop.SaveWorkshopRequestDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopDto;
import com.eduardo.workshopfast.entities.Workshop;

public interface WorkshopService {

    WorkshopDto create(SaveWorkshopRequestDto requestDto);

    Workshop getReferenceById(Long id);
}
