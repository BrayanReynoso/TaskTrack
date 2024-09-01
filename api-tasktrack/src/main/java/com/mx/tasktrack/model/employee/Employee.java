package com.mx.tasktrack.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mx.tasktrack.model.assignment.Assignment;
import com.mx.tasktrack.model.department.Department;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    private Date hireDate;

    @Column(nullable = false, length = 5)
    private Boolean status;

    /*
       Configuration of relationships between entities
        - Un empleado pertenece a un departamento (relación muchos a uno con Department).
		- Un empleado puede estar asignado a varios proyectos (relación uno a muchos con Assignment).
    */
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private List<Assignment> assignments;
}
