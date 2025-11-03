package com.eduardo.workshopfast.repositories;

import com.eduardo.workshopfast.entities.Collaborator;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
    @Query(value = """
        SELECT c FROM Collaborator c
          LEFT JOIN FETCH c.workshops cWorkshops
          LEFT JOIN FETCH cWorkshops.workshop workshop
    """)
    List<Collaborator> findAllSortedWithRelatedData(Sort sort);
}
