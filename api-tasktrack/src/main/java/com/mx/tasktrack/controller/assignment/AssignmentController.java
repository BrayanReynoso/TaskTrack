package com.mx.tasktrack.controller.assignment;

import com.mx.tasktrack.dto.assignment.AssignmentDto;
import com.mx.tasktrack.model.assignment.Assignment;
import com.mx.tasktrack.service.assignment.AssignmentService;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Response<Assignment>> getAssignmentById(@PathVariable("id") long id) {
        return new ResponseEntity<>(
                this.assignmentService.getOneAssignmentById(id), HttpStatus.OK
        );
    }

    @PostMapping("/register")
    public ResponseEntity<Response<Assignment>> registerAssignment(@RequestBody AssignmentDto assignmentDto) {
        return new ResponseEntity<>(
                this.assignmentService.createAssignment(assignmentDto.getAssignment()), HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response<Assignment>> updateAssignment(@RequestBody AssignmentDto assignmentDto) {
        return new ResponseEntity<>(
                this.assignmentService.updateAssignment(assignmentDto.getAssignment()), HttpStatus.OK
        );
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<Response<Assignment>> changeStatus(@PathVariable("id") long id) {
        return new ResponseEntity<>(
                this.assignmentService.changeStatusAssignment(id), HttpStatus.OK
        );
    }

}
