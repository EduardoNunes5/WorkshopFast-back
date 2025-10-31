package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.entities.Collaborator;

import com.eduardo.workshopfast.dto.collaborator.SaveCollaboratorRequestDto;
import com.eduardo.workshopfast.dto.collaborator.SaveCollaboratorResponseDto;

public interface CollaboratorService {
    SaveCollaboratorResponseDto create(SaveCollaboratorRequestDto collaboratorRequestDto);

    Collaborator getReferenceById(Long id);
}
