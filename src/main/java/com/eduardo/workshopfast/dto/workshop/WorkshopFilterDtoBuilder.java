package com.eduardo.workshopfast.dto.workshop;

import java.time.LocalDateTime;

public class WorkshopFilterDtoBuilder {
    private String collaboratorName;
    private LocalDateTime realizationDate;
    private String workshopName;

    public WorkshopFilterDtoBuilder setCollaboratorName(String collaboratorName) {
        this.collaboratorName = collaboratorName;
        return this;
    }

    public WorkshopFilterDtoBuilder setRealizationDate(LocalDateTime realizationDate) {
        this.realizationDate = realizationDate;
        return this;
    }

    public WorkshopFilterDtoBuilder setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
        return this;
    }

    public WorkshopFilterDto build() {
        return new WorkshopFilterDto(collaboratorName, realizationDate, workshopName);
    }
}
