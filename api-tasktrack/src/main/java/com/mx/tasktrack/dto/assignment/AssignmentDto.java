package com.mx.tasktrack.dto.assignment;

import com.mx.tasktrack.model.assignment.Assignment;
import com.mx.tasktrack.model.employee.Employee;
import com.mx.tasktrack.model.project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentDto {
    private long id;
    private String role;
    private Date assignmentDate;
    private Boolean status;
    private Employee employee;
    private Project project;

    public Assignment getAssignment() {
        return new Assignment(
                getId(),
                getRole(),
                getAssignmentDate(),
                getStatus(),
                getEmployee(),
                getProject()
        );
    }
}
