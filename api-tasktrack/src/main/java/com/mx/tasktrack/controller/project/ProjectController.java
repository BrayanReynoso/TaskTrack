package com.mx.tasktrack.controller.project;

import com.mx.tasktrack.dto.project.ProjectDto;
import com.mx.tasktrack.model.project.Project;
import com.mx.tasktrack.service.project.ProjectService;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${API-URL}/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public ResponseEntity<Response<List<Project>>> getProjects() {
        return new ResponseEntity<>(
                this.projectService.getAllProjects(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Project>> getProject(@PathVariable Long id) {
        return new ResponseEntity<>(
                this.projectService.getOneProjectById(id), HttpStatus.OK
        );
    }

    @PostMapping("/register")
    public ResponseEntity<Response<Project>> registerProject(@RequestBody ProjectDto projectDto) {
        return new ResponseEntity<>(
                this.projectService.createProject(projectDto.getProkect()), HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response<Project>> updateProject(@RequestBody ProjectDto projectDto) {
        return new ResponseEntity<>(
                this.projectService.updateProject(projectDto.getProkect()), HttpStatus.OK
        );
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<Response<Project>> deleteProject(@PathVariable Long id) {
        return new ResponseEntity<>(
                this.projectService.changeStatusProject(id), HttpStatus.OK
        );
    }
}
