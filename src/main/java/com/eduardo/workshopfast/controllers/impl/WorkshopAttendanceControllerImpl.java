package com.eduardo.workshopfast.controllers.impl;

import com.eduardo.workshopfast.controllers.WorkshopAttendanceController;
import com.eduardo.workshopfast.dto.collaborator.CollaboratorDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopFilterDto;
import com.eduardo.workshopfast.dto.workshop.WorkshopFilterDtoBuilder;
import com.eduardo.workshopfast.dto.workshop.WorkshopSummaryDto;
import com.eduardo.workshopfast.dto.workshop_attendance.*;
import com.eduardo.workshopfast.services.WorkshopAttendanceService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class WorkshopAttendanceControllerImpl implements WorkshopAttendanceController {

    private final WorkshopAttendanceService service;

    public WorkshopAttendanceControllerImpl(WorkshopAttendanceService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/atas")
    @ResponseStatus(HttpStatus.CREATED)
    public SaveWorkshopAttendanceResponseDto create(@RequestBody @Valid SaveWorkshopAttendanceRequestDto workshopAttendanceRequest) {
        return service.create(workshopAttendanceRequest);
    }

    @Override
    @PutMapping("/workshops/{id}/atas/{workshopAttendanceId}")
    public AddCollaboratorToWorkshopAttendanceResponseDto addCollaboratorByWorkshopIdAndWorkshopAttendanceId(@PathVariable Long id, @PathVariable Long workshopAttendanceId, @RequestBody @Valid AddCollaboratorToWorkshopAttendanceRequestDto request) {
        return service.addCollaborator(id, workshopAttendanceId, request.collaboratorId());
    }

    @Override
    @DeleteMapping("/atas/{id}/colaboradores/{collaboratorId}")
    public void removeCollaboratorWorkshopAttendanceId(@PathVariable Long id, @PathVariable Long collaboratorId) {
        service.removeCollaboratorById(id, collaboratorId);
    }

    @Override
    @GetMapping("/atas")
    public List<CollaboratorDto> findCollaboratorsWithWorkshopAttendanceSortedByName() {
        return service.findCollaboratorsAndWorkshopAttendanceSortedByName();
    }

    @Override
    @GetMapping(value = "/atas", params = "workshopNome")
    public List<WorkshopSummaryDto> findWorkshopsWithCollaboratorByWorkshopName(@RequestParam(name = "workshopNome") String workshopName) {
        WorkshopFilterDto filterDto = new WorkshopFilterDtoBuilder()
                .setWorkshopName(workshopName)
                .build();
        return service.findWorkshopWithCollaboratorsByFilters(filterDto);
    }

    @Override
    @GetMapping(value = "/atas", params = "data")
    public List<WorkshopSummaryDto> findWorkshopsWithCollaboratorByRealizationDate(@RequestParam(name = "data") @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime realizationDate) {
        WorkshopFilterDto filterDto = new WorkshopFilterDtoBuilder()
                .setRealizationDate(realizationDate)
                .build();
        return service.findWorkshopWithCollaboratorsByFilters(filterDto);
    }

    // Optei por adicionar mais esse endpoint, pois o mockup do front traz um campo a mais para filtrar workshop por nome de colaboradores
    @Override
    @GetMapping(value = "/atas", params = "colaboradorNome")
    public List<WorkshopSummaryDto> findWorkshopsWithCollaboratorByCollaboratorName(@RequestParam(name = "colaboradorNome") String collaboratorName) {
        WorkshopFilterDto filterDto = new WorkshopFilterDtoBuilder()
                .setCollaboratorName(collaboratorName)
                .build();
        return service.findWorkshopWithCollaboratorsByFilters(filterDto);
    }


    // Criei esse endpoint retornando os workshops ordenados pelo nome para poder popular a tabela do front
    @Override
    @GetMapping("/v2/atas")
    public List<WorkshopSummaryDto> findWorkshopsWithCollaboratorSortedByName() {
        WorkshopFilterDto filterDto = new WorkshopFilterDtoBuilder()
                .setSort(Sort.by(Sort.Direction.ASC, "name"))
                .build();
        return service.findWorkshopWithCollaboratorsByFilters(filterDto);
    }

}
