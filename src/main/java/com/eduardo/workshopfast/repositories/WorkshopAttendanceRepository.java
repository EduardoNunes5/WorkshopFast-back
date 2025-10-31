package com.eduardo.workshopfast.repositories;

import com.eduardo.workshopfast.entities.WorkshopAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopAttendanceRepository extends JpaRepository<WorkshopAttendance, Long> {

    boolean existsByWorkshop_id(Long workshopId);
}
