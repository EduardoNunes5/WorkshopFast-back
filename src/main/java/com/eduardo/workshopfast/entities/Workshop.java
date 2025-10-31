package com.eduardo.workshopfast.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime realizationDate;

    private String description;

    @OneToOne(mappedBy = "workshop")
    private WorkshopAttendance workshopAttendance;

    public Workshop() {
    }

    public Workshop(String name, LocalDateTime realizationDate, String description) {
        this.name = name;
        this.realizationDate = realizationDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(LocalDateTime realizationDate) {
        this.realizationDate = realizationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WorkshopAttendance getWorkshopAttendance() {
        return workshopAttendance;
    }

    public void setWorkshopAttendance(WorkshopAttendance workshopAttendance) {
        this.workshopAttendance = workshopAttendance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workshop workshop = (Workshop) o;
        return Objects.equals(id, workshop.id) && Objects.equals(name, workshop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
