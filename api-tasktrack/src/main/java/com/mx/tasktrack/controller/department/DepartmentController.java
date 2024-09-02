package com.mx.tasktrack.controller.department;

import com.mx.tasktrack.dto.department.DepartmentDto;
import com.mx.tasktrack.model.department.Department;
import com.mx.tasktrack.service.department.DepartmentService;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${API-URL}/department")
@CrossOrigin("*")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public ResponseEntity<Response<List<Department>>> getAllDepartments() {
        return new ResponseEntity<>(
                this.departmentService.getAllDepartments(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Department>> getDepartmentById(@PathVariable("id") long id) {
        return new ResponseEntity<>(
               this.departmentService.getOneDepartmentById(id), HttpStatus.OK
        );
    }

    @PostMapping("/register")
    public ResponseEntity<Response<Department>> registerDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(
                this.departmentService.createDepartment(departmentDto.getDepartment()), HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response<Department>> updateDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(
                this.departmentService.updateDepartment(departmentDto.getDepartment()), HttpStatus.OK
        );
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<Response<Department>> ChangeStatus(@PathVariable("id") long id) {
        return new ResponseEntity<>(
                this.departmentService.changeStatusDepartment(id), HttpStatus.OK
        );
    }
}
