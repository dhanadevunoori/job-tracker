package com.jobtracker.controller;

import com.jobtracker.model.User;
import com.jobtracker.repository.JobApplicationRepository;
import com.jobtracker.repository.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final JobApplicationRepository repository;
    private final UserRepository userRepository;

    public AnalyticsController(JobApplicationRepository repository,
                                UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public Map<String, Object> getAnalytics(
            @AuthenticationPrincipal UserDetails userDetails) {

        User user = userRepository.findByEmail(userDetails.getUsername())
            .orElseThrow(() -> new RuntimeException("User not found"));

        var all = repository.findByUserId(user.getId());
        long total = all.size();
        long applied = all.stream().filter(a -> "Applied".equals(a.getStatus())).count();
        long interview = all.stream().filter(a -> "Interview".equals(a.getStatus())).count();
        long offer = all.stream().filter(a -> "Offer".equals(a.getStatus())).count();
        long rejected = all.stream().filter(a -> "Rejected".equals(a.getStatus())).count();

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalApplications", total);
        stats.put("applied", applied);
        stats.put("interviews", interview);
        stats.put("offers", offer);
        stats.put("rejected", rejected);
        stats.put("successRate", total > 0 ? (offer * 100.0 / total) + "%" : "0%");
        return stats;
    }
}