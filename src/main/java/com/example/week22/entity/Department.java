package com.example.week22.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "dept_name")
    private String deptName;

    private String desciption;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Employee> employees;

}
