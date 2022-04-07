package com.bankbazaar.javaproblems.problem1.model;

/**
 * Member class
 */

public class Member
{
    private String name;
    private String age;
    private String phoneNumber;
    private String address;
    private String salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * Print member details
     * @param department
     */
    public void getDetails(String department)
    {
        System.out.println("Name: " + this.name);
        System.out.println("Phone: " + this.phoneNumber);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + this.salary);
    }
}

