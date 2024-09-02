package com.mx.tasktrack.dto.project;

import com.mx.tasktrack.model.assignment.Assignment;
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
public class ProjectDto {
    private long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Double budget;
    private Boolean status;
    private Assignment assignment;

    public Project getProkect(){
        return new Project(
                getId(),
                getName(),
                getDescription(),
                getStartDate(),
                getEndDate(),
                getBudget(),
                getStatus(),
                null
        );
    }
}
