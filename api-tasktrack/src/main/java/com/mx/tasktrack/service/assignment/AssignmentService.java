package com.mx.tasktrack.service.assignment;

import com.mx.tasktrack.model.assignment.Assignment;
import com.mx.tasktrack.repository.assignment.AssignmentRepository;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public Response<Assignment> getOneAssignmentById(long id) {
        Optional<Assignment> exist = assignmentRepository.findById(id);
        if (exist.isPresent()) {
            return new Response<>(
                    exist.get(),
                    200,
                    "Assignment found",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Assignment not found",
                false
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Assignment> createAssignment(Assignment assignment) {
        Optional<Assignment> exist = assignmentRepository.findById(assignment.getId());
        if (!exist.isPresent()) {
            return new Response<>(
                    this.assignmentRepository.save(assignment),
                    200,
                    "Assignment registered successfully",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Error when registering the assignment",
                true
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Assignment> updateAssignment(Assignment assignment) {
        Optional<Assignment> exist = assignmentRepository.findById(assignment.getId());
        if (exist.isPresent()) {
            exist.get().setRole(assignment.getRole());
            exist.get().setAssignmentDate(assignment.getAssignmentDate());
            exist.get().setStatus(assignment.getStatus());
            exist.get().setEmployee(assignment.getEmployee());
            exist.get().setProject(assignment.getProject());
            return new Response<>(
                    this.assignmentRepository.saveAndFlush(exist.get()),
                    200,
                    "Assignment updated successfully",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Error updating assignment",
                true
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Assignment> changeStatusAssignment(long id) {
        Optional<Assignment> exist = assignmentRepository.findById(id);
        if (exist.isPresent()) {
            exist.get().setStatus(!exist.get().getStatus());
            return new Response<>(
                    this.assignmentRepository.saveAndFlush(exist.get()),
                    200,
                    "The status change has been carried out correctly",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Error updating assignment status",
                true
        );
    }
}
