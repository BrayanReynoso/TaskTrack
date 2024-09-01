package com.mx.tasktrack.service.department;

import com.mx.tasktrack.model.department.Department;
import com.mx.tasktrack.repository.department.DepartmentRepository;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Response<List<Department>> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        if (!departments.isEmpty()) {
            return new Response<>(
                    this.departmentRepository.findAll(),
                    200,
                    "OK",
                    false
            );
        }
        return new Response<>(
                null,
                201,
                "No recorded data found",
                false
        );
    }

}
