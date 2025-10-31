package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.dto.collaborator.CollaboratorDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopFilterDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopFilterDtoBuilder;
import com.eduardo.workshopfast.dto.workshop.WorkshopWithCollaboratorDto;
import com.eduardo.workshopfast.dto.workshop_attendance.*;
import com.eduardo.workshopfast.services.WorkshopAttendanceService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/atas")
    public List<CollaboratorDto> findCollaboratorsWithWorkshopAttendanceSortedByName() {
        return service.findCollaboratorsAndWorkshopAttendanceSortedByName();
    }

    @GetMapping(value = "/atas", params = "workshopNome")
    public List<WorkshopWithCollaboratorDto> findByWorkshopName(@RequestParam(name = "workshopNome") String workshopName) {
        WorkshopFilterDto filterDto = new WorkshopFilterDtoBuilder()
                .setWorkshopName(workshopName)
                .build();
        return service.findWorkshopWithCollaboratorsByFilters(filterDto);
    }

    @GetMapping(value = "/atas", params = "data")
    public List<WorkshopWithCollaboratorDto> findByRealizationDate(@RequestParam(name = "data") @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime realizationDate) {
        WorkshopFilterDto filterDto = new WorkshopFilterDtoBuilder()
                .setRealizationDate(realizationDate)
                .build();
        return service.findWorkshopWithCollaboratorsByFilters(filterDto);
    }

    // Optei por adicionar mais esse endpoint, pois o mockup do front traz um campo a mais para filtrar workshop por nome de colaboradores
    @GetMapping(value = "/atas", params = "colaboradorNome")
    public List<WorkshopWithCollaboratorDto> findByCollaboratorName(@RequestParam(name = "colaboradorNome") String collaboratorName) {
        WorkshopFilterDto filterDto = new WorkshopFilterDtoBuilder()
                .setCollaboratorName(collaboratorName)
                .build();
        return service.findWorkshopWithCollaboratorsByFilters(filterDto);
    }

}
