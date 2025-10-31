package com.eduardo.workshopfast.services;

import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceRequestDto;
import com.eduardo.workshopfast.dto.workshop_attendance.SaveWorkshopAttendanceResponseDto;

public interface WorkshopAttendanceService {

    SaveWorkshopAttendanceResponseDto create(SaveWorkshopAttendanceRequestDto workshopAttendanceRequestDto);
}
