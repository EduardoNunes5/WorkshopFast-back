package com.eduardo.workshopfast.controllers.impl;

import com.eduardo.workshopfast.controllers.WorkshopController;
import com.eduardo.workshopfast.dto.workshop.SaveWorkshopRequestDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopDto;
import com.eduardo.workshopfast.services.WorkshopService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/workshops")
public class WorkshopControllerImpl implements WorkshopController {

    private final WorkshopService workshopService;

    public WorkshopControllerImpl(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkshopDto createWorkshop(@RequestBody @Valid SaveWorkshopRequestDto workshopRequestDto) {
        return workshopService.create(workshopRequestDto);
    }
}
