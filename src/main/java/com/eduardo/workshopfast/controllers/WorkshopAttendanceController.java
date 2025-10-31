package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.dto.workshop_attendance.UpdateWorkshopAttendanceRequestDto;
import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceRequestDto;
import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceResponseDto;
import com.eduardo.workshopfast.dto.workshop_attendance.UpdateWorkshopAttendanceResponseDto;
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

    @PutMapping("/workshops/{id}/atas/{workshopAttendanceId}")
    public UpdateWorkshopAttendanceResponseDto addCollaborator(@PathVariable Long id, @PathVariable Long workshopAttendanceId, @RequestBody @Valid UpdateWorkshopAttendanceRequestDto request) {
        return service.addCollaborator(id, workshopAttendanceId, request.collaboratorId());
    }

    @DeleteMapping("/atas/{id}/colaboradores/{collaboratorId}")
    public void removeCollaborator(@PathVariable Long id, @PathVariable Long collaboratorId) {
        service.removeCollaborator(id, collaboratorId);
    }

}
