package com.mx.tasktrack.service.project;

import com.mx.tasktrack.model.project.Project;
import com.mx.tasktrack.repository.project.ProjectRepository;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public Response<Project> getOneProjectById(long id) {
        Optional<Project> exist = this.projectRepository.findById(id);
        if (exist.isPresent()) {
            return new Response<>(
                    exist.get(),
                    200,
                    "Project found",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Project not found",
                true
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Project> createProject(Project project) {
        Optional<Project> exist = this.projectRepository.findProjectByName(project.getName());
        if (!exist.isPresent()) {
            return new Response<>(
                    this.projectRepository.save(project),
                    200,
                    "Project successfully registered",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Error registering project",
                true
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Project> updateProject(Project project) {
        Optional<Project> exist = this.projectRepository.findById(project.getId());
        if (exist.isPresent()) {
            exist.get().setName(project.getName());
            exist.get().setDescription(project.getDescription());
            exist.get().setStartDate(project.getStartDate());
            exist.get().setEndDate(project.getEndDate());
            exist.get().setStatus(project.getStatus());
            exist.get().setBudget(project.getBudget());
            return new Response<>(
                    this.projectRepository.saveAndFlush(exist.get()),
                    200,
                    "Project successfully updated",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Error updating project",
                true
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Project> changeStatusProject(long id) {
        Optional<Project> exist = this.projectRepository.findById(id);
        if (exist.isPresent()) {
            exist.get().setStatus(!exist.get().getStatus());
            return new Response<>(
                    this.projectRepository.saveAndFlush(exist.get()),
                    200,
                    "",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "",
                true
        );
    }
}
