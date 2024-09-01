package com.mx.tasktrack.repository.project;

import com.mx.tasktrack.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Override
    Optional<Project> findById(Long id);

    Optional<Project> findByName(String name);
}
