package com.eduardo.workshopfast.repositories;

import com.eduardo.workshopfast.entities.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
