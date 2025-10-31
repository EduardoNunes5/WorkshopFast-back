package com.eduardo.workshopfast.controllers;

import com.eduardo.workshopfast.dto.collaborator.SaveCollaboratorRequestDto;
import com.eduardo.workshopfast.dto.collaborator.SaveCollaboratorResponseDto;
import com.eduardo.workshopfast.services.CollaboratorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/colaboradores")
public class CollaboratorController {

    private final CollaboratorService service;

    public CollaboratorController(CollaboratorService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaveCollaboratorResponseDto create(@RequestBody @Valid SaveCollaboratorRequestDto collaboratorRequestDto) {
        return service.create(collaboratorRequestDto);
    }
}
