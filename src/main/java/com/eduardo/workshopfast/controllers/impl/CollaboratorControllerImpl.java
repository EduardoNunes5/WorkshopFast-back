package com.eduardo.workshopfast.controllers.impl;

import com.eduardo.workshopfast.controllers.CollaboratorController;
import com.eduardo.workshopfast.dto.collaborator.SaveCollaboratorRequestDto;
import com.eduardo.workshopfast.dto.collaborator.CollaboratorDto;
import com.eduardo.workshopfast.services.CollaboratorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/colaboradores")
public class CollaboratorControllerImpl implements CollaboratorController {

    private final CollaboratorService service;

    public CollaboratorControllerImpl(CollaboratorService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CollaboratorDto create(@RequestBody @Valid SaveCollaboratorRequestDto collaboratorRequestDto) {
        return service.create(collaboratorRequestDto);
    }
}
