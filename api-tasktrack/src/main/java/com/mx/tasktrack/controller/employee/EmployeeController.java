package com.mx.tasktrack.controller.employee;

import com.mx.tasktrack.dto.employee.EmployeeDto;
import com.mx.tasktrack.model.employee.Employee;
import com.mx.tasktrack.service.employee.EmployeeService;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{email}")
    public ResponseEntity<Response<Employee>> getByOneEmployee(@PathVariable("email") String email) {
        return new ResponseEntity<>(
                this.employeeService.getByOneEmployee(email), HttpStatus.OK
        );
    }

    @PostMapping("/register")
    public ResponseEntity<Response<Employee>> createEmployee(@RequestBody EmployeeDto employee) {
        return new ResponseEntity<>(
                this.employeeService.createEmployee(employee.getEmployee()), HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response<Employee>> updateEmployee(@RequestBody EmployeeDto employee) {
        return new ResponseEntity<>(
                this.employeeService.updateEmployee(employee.getEmployee()), HttpStatus.OK
        );
    }

    @DeleteMapping("/status/{email}")
    public ResponseEntity<Response<Employee>> deleteEmployee(@PathVariable("email") String email) {
        return new ResponseEntity<>(
                this.employeeService.changeStatusEmployee(email), HttpStatus.OK
        );
    }
}
