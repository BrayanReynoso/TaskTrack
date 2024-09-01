package com.mx.tasktrack.service.assignment;

import com.mx.tasktrack.model.assignment.Assignment;
import com.mx.tasktrack.repository.assignment.AssignmentRepository;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Transactional(readOnly = true)
    public Response<List<Assignment>> getAssignments() {
        List<Assignment> assignments = assignmentRepository.findAll();
        if (!assignments.isEmpty()) {
            return new Response<>(
                    this.assignmentRepository.findAll(),
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
