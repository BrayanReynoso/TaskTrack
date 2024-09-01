package com.mx.tasktrack.model.department;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mx.tasktrack.model.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 5)
    private Boolean status;

    /*
       Configuration of relationships between entities
        - Un departamento tiene muchos empleados (relación uno a muchos con Employee).
    */
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;
}
