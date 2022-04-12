package com.bankbazaar.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "department")
public class Department{
    @Id
    @GeneratedValue
    @Column(name="department_id")
    private long id;
    @Column(name="department_name")
    private String name;
    @Column(name="department_floor")
    private int departmentFloor;
    @Column(name="department_phone")
    private String departmentPhone;
}