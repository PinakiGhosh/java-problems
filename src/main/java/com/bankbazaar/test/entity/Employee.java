package com.bankbazaar.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;
    @Column(name="salary")
    private String salary;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="department_id", referencedColumnName = "department_id")
    private Department departmentId;
}
