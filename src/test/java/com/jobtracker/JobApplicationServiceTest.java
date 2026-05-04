package com.jobtracker;

import com.jobtracker.model.JobApplication;
import com.jobtracker.model.User;
import com.jobtracker.repository.JobApplicationRepository;
import com.jobtracker.service.JobApplicationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JobApplicationServiceTest {

    @Mock
    private JobApplicationRepository repository;

    @InjectMocks
    private JobApplicationService service;

    @Test
    void testCreateApplication() {
        JobApplication app = new JobApplication();
        app.setCompanyName("Google");
        app.setStatus("Applied");
        when(repository.save(app)).thenReturn(app);
        JobApplication result = service.create(app);
        assertEquals("Google", result.getCompanyName());
        verify(repository, times(1)).save(app);
    }

    @Test
    void testGetAllByUser() {
        User user = new User();
        user.setId(1L);
        JobApplication app = new JobApplication();
        app.setCompanyName("Amazon");
        when(repository.findByUserId(1L)).thenReturn(List.of(app));
        List<JobApplication> result = service.getAllByUser(user);
        assertEquals(1, result.size());
    }

    @Test
    void testDeleteApplication() {
        doNothing().when(repository).deleteById(1L);
        service.delete(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}
