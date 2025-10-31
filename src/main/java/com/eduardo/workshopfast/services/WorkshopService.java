package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.dto.workshop.SaveWorkshopRequestDto;
import com.eduardo.workshopfast.dto.workshop.SaveWorkshopResponseDto;
import com.eduardo.workshopfast.entities.Workshop;

public interface WorkshopService {

    SaveWorkshopResponseDto create(SaveWorkshopRequestDto requestDto);

    Workshop getReferenceById(Long id);
}
