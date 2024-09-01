package com.mx.tasktrack.repository.assignment;

import com.mx.tasktrack.model.assignment.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    @Override
    Optional<Assignment> findById(Long id);
}
