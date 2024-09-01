package com.mx.tasktrack.service.employee;

import com.mx.tasktrack.model.employee.Employee;
import com.mx.tasktrack.repository.employee.EmployeeRepository;
import com.mx.tasktrack.utils.Response;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Response<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if (!employees.isEmpty()){
            return new Response<>(
                    this.employeeRepository.findAll(),
                    200,
                    "OK",
                    false
            );
        }
        return new Response<>(
                null,
                201,
                "No recorded data found!",
                false
        );
    }
}
