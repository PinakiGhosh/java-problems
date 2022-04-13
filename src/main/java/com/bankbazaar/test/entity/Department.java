package com.bankbazaar.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "department")
public class Department{
    @Id
    @GeneratedValue
    @Column(name="department_id")
    private Long id;

    @Column(name="department_name")
    @NotBlank(message = "Department Name is mandatory")
    private String name;

    @Column(name="department_floor")
    @NotNull(message = "Floor cannot be null")
    private Integer departmentFloor;

    @Column(name="department_phone")
    @Pattern(regexp="(^$|\\d{10})")
    private String departmentPhone;
}