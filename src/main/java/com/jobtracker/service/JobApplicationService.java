package com.jobtracker.service;

import com.jobtracker.model.JobApplication;
import com.jobtracker.model.User;
import com.jobtracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public List<JobApplication> getAllByUser(User user) {
        return repository.findByUserId(user.getId());
    }

    public JobApplication create(JobApplication application) {
        return repository.save(application);
    }

    public JobApplication update(Long id, JobApplication updated) {
        JobApplication existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));
        existing.setCompanyName(updated.getCompanyName());
        existing.setJobRole(updated.getJobRole());
        existing.setStatus(updated.getStatus());
        existing.setAppliedDate(updated.getAppliedDate());
        existing.setNotes(updated.getNotes());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<JobApplication> filterByStatus(User user, String status) {
        return repository.findByUserIdAndStatus(user.getId(), status);
    }
}