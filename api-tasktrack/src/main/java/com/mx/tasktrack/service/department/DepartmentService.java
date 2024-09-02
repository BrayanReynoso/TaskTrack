package com.mx.tasktrack.service.department;

import com.mx.tasktrack.model.department.Department;
import com.mx.tasktrack.repository.department.DepartmentRepository;
import com.mx.tasktrack.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @Transactional(readOnly = true)
    public Response<Department> getOneDepartmentById(long id){
       Optional<Department> exist = this.departmentRepository.findById(id);
        if (exist.isPresent()) {
            return new Response<>(
                    exist.get(),
                    200,
                    "Department found",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Department not found",
                true
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Department> createDepartment(Department department) {
        Optional<Department> exist = this.departmentRepository.getDepartmentByName(department.getName());
        if (!exist.isPresent()) {
            return new Response<>(
                    this.departmentRepository.save(department),
                    200,
                    "Department successfully registered",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "The department is already registered",
                true
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Department> updateDepartment(Department department) {
        Optional<Department> exist = this.departmentRepository.findById(department.getId());
        if (exist.isPresent()) {
            exist.get().setName(department.getName());
            exist.get().setDescription(department.getDescription());
            exist.get().setStatus(department.getStatus());
            return new Response<>(
                    this.departmentRepository.saveAndFlush(exist.get()),
                    200,
                    "The department has been updated",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "Error updating department",
                false
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Department> changeStatusDepartment(long id) {
        Optional<Department> exist = this.departmentRepository.findById(id);
        if (exist.isPresent()) {
            exist.get().setStatus(!exist.get().getStatus());
            return new Response<>(
                    this.departmentRepository.saveAndFlush(exist.get()),
                    200,
                    "The department status has been changed successfully",
                    false
            );
        }
        return new Response<>(
                null,
                400,
                "error when changing department status",
                true
        );
    }

}
