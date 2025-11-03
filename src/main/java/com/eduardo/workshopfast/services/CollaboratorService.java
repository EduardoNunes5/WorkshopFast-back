package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.entities.Collaborator;

import com.eduardo.workshopfast.dto.collaborator.SaveCollaboratorRequestDto;
import com.eduardo.workshopfast.dto.collaborator.CollaboratorDto;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CollaboratorService {
    CollaboratorDto create(SaveCollaboratorRequestDto collaboratorRequestDto);

    Collaborator getReferenceById(Long id);

    Optional<Collaborator> findById(Long id);

    List<Collaborator> findAllSortedWithRelatedData(Sort sort);
}
