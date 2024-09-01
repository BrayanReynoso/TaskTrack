package com.mx.tasktrack.controller.employee;

import com.mx.tasktrack.model.employee.Employee;
import com.mx.tasktrack.service.employee.EmployeeService;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("${API-URL}/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<Response<List<Employee>>> getAllEmployees() {
        return new ResponseEntity<>(
                this.employeeService.getAllEmployees(), HttpStatus.OK
        );
    }
}
