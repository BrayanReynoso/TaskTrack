package com.mx.tasktrack.service.project;

import com.mx.tasktrack.model.project.Project;
import com.mx.tasktrack.repository.project.ProjectRepository;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public Response<List<Project>> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        if (!projects.isEmpty()) {
            return new Response<>(
                    this.projectRepository.findAll(),
                    200,
                    "OK",
                    false
            );
        }
        return new Response<>(
                null,
                201,
                "No recorded data found",
                false
        );
    }
}
