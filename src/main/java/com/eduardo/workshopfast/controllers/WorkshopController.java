package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.dto.workshop.SaveWorkshopRequestDto;
import com.eduardo.workshopfast.dto.workshop.SaveWorkshopResponseDto;
import com.eduardo.workshopfast.services.WorkshopService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/workshops")
public class WorkshopController {

    private final WorkshopService workshopService;

    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaveWorkshopResponseDto createWorkshop(@RequestBody @Valid SaveWorkshopRequestDto workshopRequestDto) {
        return workshopService.create(workshopRequestDto);
    }
}
