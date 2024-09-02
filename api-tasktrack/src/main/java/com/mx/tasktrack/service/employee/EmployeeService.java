package com.mx.tasktrack.service.employee;

import com.mx.tasktrack.model.employee.Employee;
import com.mx.tasktrack.repository.employee.EmployeeRepository;
import com.mx.tasktrack.utils.Response;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public Response<Employee> getByOneEmployee(String email) {
        Optional<Employee> exist = this.employeeRepository.findByEmail(email);
        if (exist.isPresent()){
            return new Response<>(
                    exist.get(),
                    200,
                    "Employee found",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Employee not found",
                true
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Employee> createEmployee(Employee employee) {
        Optional<Employee> exist = this.employeeRepository.findByEmail(employee.getEmail());
        if (!exist.isPresent()){
            return new Response<>(
                    this.employeeRepository.save(employee),
                    200,
                    "Registered employee",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "The employee is already registered",
                true
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Employee> updateEmployee(Employee employee) {
        Optional<Employee> exist = this.employeeRepository.findById(employee.getId());
        if (exist.isPresent()){
            exist.get().setFirstName(employee.getFirstName());
            exist.get().setLastName(employee.getLastName());
            exist.get().setHireDate(employee.getHireDate());
            exist.get().setEmail(employee.getEmail());
            exist.get().setSalary(employee.getSalary());
            exist.get().setStatus(employee.getStatus());
            exist.get().setDepartment(employee.getDepartment());
            return new Response<>(
                    this.employeeRepository.saveAndFlush(exist.get()),
                    200,
                    "Employee successfully updated",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Error updating employee data",
                true
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Employee> changeStatusEmployee(String email) {
        Optional<Employee> exist = this.employeeRepository.findByEmail(email);
        if (exist.isPresent()){
            exist.get().setStatus(!exist.get().getStatus());
            return new Response<>(
                    this.employeeRepository.saveAndFlush(exist.get()),
                    200,
                    "The employee's status has been updated",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Error updating employee status",
                true
        );
    }
}
