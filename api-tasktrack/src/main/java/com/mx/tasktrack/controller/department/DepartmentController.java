package com.mx.tasktrack.controller.department;

import com.mx.tasktrack.model.department.Department;
import com.mx.tasktrack.service.department.DepartmentService;
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
}
