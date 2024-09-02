package com.mx.tasktrack.repository.department;

import com.mx.tasktrack.model.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Override
    Optional<Department> findById(Long id);

    Optional<Department> getDepartmentByName(String name);
}
