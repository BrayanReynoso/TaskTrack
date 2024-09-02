package com.mx.tasktrack.repository.employee;

import com.mx.tasktrack.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    Optional<Employee> findById(Long id);

    Optional<Employee> findByEmail(String email);
}
