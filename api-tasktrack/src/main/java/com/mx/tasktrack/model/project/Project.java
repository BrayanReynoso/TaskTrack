package com.mx.tasktrack.model.project;

import com.mx.tasktrack.model.assignment.Assignment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private Double budget;

    @Column(nullable = false, length = 5)
    private Boolean status;

    /*
       Configuration of relationships between entities
        -Un proyecto puede tener varios empleados asignados a él (relación uno a muchos con Assignment).
    */
    @OneToMany(mappedBy = "project")
    private List<Assignment> assignments;

}
