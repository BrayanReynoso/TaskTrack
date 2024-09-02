package com.mx.tasktrack.dto.employee;

import com.mx.tasktrack.model.department.Department;
import com.mx.tasktrack.model.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private Date hireDate;
    private Boolean status;
    private Department department;

    public Employee getEmployee(){
        return new Employee(
                getId(),
                getFirstName(),
                getLastName(),
                getEmail(),
                getSalary(),
                getHireDate(),
                getStatus(),
                getDepartment(),
                null
        );
    }

}
