package com.jobtracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String jobRole;
    private String status;
    private LocalDate appliedDate;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() { return id; }
    public String getCompanyName() { return companyName; }
    public String getJobRole() { return jobRole; }
    public String getStatus() { return status; }
    public LocalDate getAppliedDate() { return appliedDate; }
    public String getNotes() { return notes; }
    public User getUser() { return user; }
    public void setId(Long id) { this.id = id; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setJobRole(String jobRole) { this.jobRole = jobRole; }
    public void setStatus(String status) { this.status = status; }
    public void setAppliedDate(LocalDate appliedDate) { this.appliedDate = appliedDate; }
    public void setNotes(String notes) { this.notes = notes; }
    public void setUser(User user) { this.user = user; }
}