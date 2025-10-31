package com.eduardo.workshopfast.services.impl;

import com.eduardo.workshopfast.dto.collaborator.SaveCollaboratorRequestDto;
import com.eduardo.workshopfast.dto.collaborator.SaveCollaboratorResponseDto;
import com.eduardo.workshopfast.entities.Collaborator;
import com.eduardo.workshopfast.repositories.CollaboratorRepository;
import com.eduardo.workshopfast.services.CollaboratorService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
class CollaboratorServiceImpl implements CollaboratorService {

    private final CollaboratorRepository repository;

    CollaboratorServiceImpl(CollaboratorRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public SaveCollaboratorResponseDto create(SaveCollaboratorRequestDto collaboratorRequestDto) {
        Collaborator savedCollaborator = new Collaborator(collaboratorRequestDto.name());
        savedCollaborator = repository.save(savedCollaborator);
        return new SaveCollaboratorResponseDto(savedCollaborator);
    }

    @Override
    public Collaborator getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Optional<Collaborator> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Collaborator> findAllSortedWithRelatedData(Sort sort) {
        return repository.findAllSortedWithRelatedData(sort);
    }
}
