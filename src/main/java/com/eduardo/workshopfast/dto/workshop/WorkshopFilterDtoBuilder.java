package com.eduardo.workshopfast.dto.workshop;

import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

public class WorkshopFilterDtoBuilder {
    private String collaboratorName;
    private LocalDateTime realizationDate;
    private String workshopName;

    private Sort sort;

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

    public WorkshopFilterDtoBuilder setSort(Sort sort) {
        this.sort = sort;
        return this;
    }

    public WorkshopFilterDto build() {
        this.sort = sort != null ? sort : Sort.by(Sort.Direction.ASC, "id");
        return new WorkshopFilterDto(collaboratorName, realizationDate, workshopName, sort);
    }
}
