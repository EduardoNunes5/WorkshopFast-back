package com.eduardo.workshopfast.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class WorkshopAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workshop_id", nullable = false)
    private Workshop workshop;

    @ManyToMany
    @JoinTable(
            name = "collaborator_workshop_attendance",
            joinColumns = @JoinColumn(name = "workshop_attendance_id"),
            inverseJoinColumns = @JoinColumn(name = "collaborator_id")
    )
    private Set<Collaborator> collaborators = new HashSet<>();

    public WorkshopAttendance() {
    }

    public WorkshopAttendance(Workshop workshop) {
        this.workshop = workshop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkshopId() {
        return getWorkshop().getId();
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public Set<Collaborator> getCollaborators() {
        return collaborators;
    }

    public void addCollaborator(Collaborator collaborator) {
        this.collaborators.add(collaborator);
    }

    public void removeCollaborator(Collaborator collaborator) {
        this.collaborators.remove(collaborator);
    }
}
