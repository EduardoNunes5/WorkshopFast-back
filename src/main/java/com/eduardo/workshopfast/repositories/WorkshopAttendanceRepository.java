package com.eduardo.workshopfast.repositories;

import com.eduardo.workshopfast.entities.WorkshopAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkshopAttendanceRepository extends JpaRepository<WorkshopAttendance, Long> {

    @Query(value = "SELECT COUNT(workshopAtt) > 0 FROM WorkshopAttendance workshopAtt WHERE workshopAtt.workshop.id = :workshopId")
    boolean existsByWorkshopId(@Param("workshopId") Long workshopId);

    @Query(value = """
        SELECT COUNT(workshopAtt) > 0
          FROM WorkshopAttendance workshopAtt
          JOIN workshopAtt.collaborators collaborator
         WHERE workshopAtt.id = :id
           AND collaborator.id = :collaboratorId
    """)
    boolean existsCollaboratorInWorkshopAttendance(@Param("id") Long id, @Param("collaboratorId") Long collaboratorId);

    @Query(value = """
        SELECT workshopAtt
          FROM WorkshopAttendance workshopAtt
         WHERE workshopAtt.id = :id
           AND workshopAtt.workshop.id = :workshopId
    """)
    Optional<WorkshopAttendance> findByIdAndWorkshopId(@Param("id") Long id, @Param("workshopId") Long workshopId);
}
