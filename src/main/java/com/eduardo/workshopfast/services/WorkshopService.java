package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.dto.SaveWorkshopRequestDto;
import com.eduardo.workshopfast.dto.SaveWorkshopResponseDto;

public interface WorkshopService {

    SaveWorkshopResponseDto create(SaveWorkshopRequestDto requestDto);
}
