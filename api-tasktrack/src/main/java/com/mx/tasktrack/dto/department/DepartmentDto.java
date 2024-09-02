package com.mx.tasktrack.dto.department;

import com.mx.tasktrack.model.department.Department;
import com.mx.tasktrack.model.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private long id;
    private String name;
    private String description;
    private Boolean status;
    private Employee employee;

    public Department getDepartment(){
        return new Department(
                getId(),
                getName(),
                getDescription(),
                getStatus(),
                null
        );
    }
}
