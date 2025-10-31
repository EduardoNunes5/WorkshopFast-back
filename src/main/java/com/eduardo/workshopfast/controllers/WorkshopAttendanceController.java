package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceRequestDto;
import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceResponseDto;
import com.eduardo.workshopfast.services.WorkshopAttendanceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class WorkshopAttendanceController {

    private final WorkshopAttendanceService service;

    public WorkshopAttendanceController(WorkshopAttendanceService service) {
        this.service = service;
    }

    @PostMapping("/atas")
    @ResponseStatus(HttpStatus.CREATED)
    public SaveWorkshopAttendanceResponseDto create(@RequestBody @Valid SaveWorkshopAttendanceRequestDto workshopAttendanceRequest) {
        return service.create(workshopAttendanceRequest);
    }
}
