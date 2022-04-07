package com.bankbazaar.javaproblems.problem1.model;


/**
 * Employee class
 */
public class Employee extends Member
{
    private String specialization;
    private String department;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

