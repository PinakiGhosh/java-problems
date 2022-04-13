package com.bankbazaar.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="name")
    @NotBlank(message = "Employee Name is mandatory")
    private String name;

    @Column(name="age")
    @NotNull(message = "Age cannot be null")
    private Integer age;

    @Column(name="salary")
    @NotBlank(message = "Salary is mandatory")
    private String salary;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="department_id", referencedColumnName = "department_id")
    private Department departmentId;
}
