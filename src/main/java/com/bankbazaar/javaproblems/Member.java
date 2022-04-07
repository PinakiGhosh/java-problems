package com.bankbazaar.javaproblems;

/**
 * Member class
 */

class Member
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
    void getDetails(String department)
    {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

