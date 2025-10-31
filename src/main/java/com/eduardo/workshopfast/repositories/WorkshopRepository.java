package com.eduardo.workshopfast.repositories;

import com.eduardo.workshopfast.entities.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {

    @Query(value = """
        SELECT workshop
          FROM Workshop workshop
          LEFT JOIN FETCH workshop.workshopAttendance workshopAtt
          LEFT JOIN FETCH workshopAtt.collaborators collaborator
         WHERE (:collaboratorName IS NULL OR LOWER(collaborator.name) LIKE CONCAT('%', LOWER(:collaboratorName) ,'%'))
           AND (:realizationDate IS NULL OR workshop.realizationDate = :realizationDate)
           AND (:workshopName IS NULL OR LOWER(workshop.name) LIKE CONCAT('%', LOWER(:workshopName), '%'))
    """)
    List<Workshop> findByCollaboratorNameAndRealizationDateAndWorkshopName(@Param("collaboratorName") String collaboratorName,
                                                                                                       @Param("realizationDate") LocalDateTime realizationDate,
                                                                                                       @Param("workshopName") String workshopName);
}
