package com.mx.tasktrack.controller.project;

import com.mx.tasktrack.model.project.Project;
import com.mx.tasktrack.service.project.ProjectService;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
