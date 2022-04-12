package com.bankbazaar.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Department")
public class Department{
    @Id
    @GeneratedValue
    @Column(name="department_id")
    private int id;
    @Column(name="department_name")
    private String name;
    @Column(name="employee_count")
    private int employeeCount;
}