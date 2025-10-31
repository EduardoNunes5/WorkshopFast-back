package com.eduardo.workshopfast.services.impl;

import com.eduardo.workshopfast.entities.Collaborator;
import com.eduardo.workshopfast.repositories.CollaboratorRepository;
import com.eduardo.workshopfast.services.CollaboratorService;
import org.springframework.stereotype.Service;

@Service
class CollaboratorServiceImpl implements CollaboratorService {

    private final CollaboratorRepository repository;

    CollaboratorServiceImpl(CollaboratorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collaborator getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }
}
