package com.mx.tasktrack.model.assignment;

import com.mx.tasktrack.model.employee.Employee;
import com.mx.tasktrack.model.project.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private Date assignmentDate;

    @Column(nullable = false, length = 5)
    private Boolean status;

     /*
       Configuration of relationships between entities
        - Una asignación vincula a un empleado con un proyecto, y define el rol del empleado en ese proyecto.
		- Tiene relaciones muchos a uno con Employee y Project.
    */

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
