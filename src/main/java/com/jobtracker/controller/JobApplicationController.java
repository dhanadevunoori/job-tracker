package com.jobtracker.controller;

import com.jobtracker.model.JobApplication;
import com.jobtracker.model.User;
import com.jobtracker.repository.UserRepository;
import com.jobtracker.service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService service;
    private final UserRepository userRepository;

    public JobApplicationController(JobApplicationService service, UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }

    private User getUser(UserDetails userDetails) {
        return userRepository.findByEmail(userDetails.getUsername())
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping
    public List<JobApplication> getAll(@AuthenticationPrincipal UserDetails userDetails) {
        return service.getAllByUser(getUser(userDetails));
    }

    @PostMapping
    public JobApplication create(@RequestBody JobApplication application,
                                  @AuthenticationPrincipal UserDetails userDetails) {
        application.setUser(getUser(userDetails));
        return service.create(application);
    }

    @PutMapping("/{id}")
    public JobApplication update(@PathVariable Long id,
                                  @RequestBody JobApplication application,
                                  @AuthenticationPrincipal UserDetails userDetails) {
        application.setUser(getUser(userDetails));
        return service.update(id, application);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @GetMapping("/filter")
    public List<JobApplication> filter(@RequestParam String status,
                                        @AuthenticationPrincipal UserDetails userDetails) {
        return service.filterByStatus(getUser(userDetails), status);
    }
}