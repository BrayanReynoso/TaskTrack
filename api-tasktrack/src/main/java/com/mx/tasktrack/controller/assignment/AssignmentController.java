package com.mx.tasktrack.controller.assignment;

import com.mx.tasktrack.model.assignment.Assignment;
import com.mx.tasktrack.service.assignment.AssignmentService;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("${API-URL}/assignment")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/")
    public ResponseEntity<Response<List<Assignment>>> getAllAssignments() {
        return new ResponseEntity<>(
                this.assignmentService.getAssignments(), HttpStatus.OK
        );
    }
}
