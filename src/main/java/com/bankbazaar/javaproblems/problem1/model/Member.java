package com.bankbazaar.javaproblems.problem1.model;

/**
 * Member class
 */

public class Member
{
    public String name;
    public String age;
    public String phoneNumber;
    public String address;
    public String salary;

    /**
     * Print member details
     * @param department
     */
    public void getDetails(String department)
    {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

