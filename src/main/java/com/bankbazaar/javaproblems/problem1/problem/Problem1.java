package com.bankbazaar.javaproblems.problem1.problem;

import com.bankbazaar.javaproblems.problem1.model.Employee;
import com.bankbazaar.javaproblems.problem1.model.Manager;

public class Problem1 {
    public static void main(String[] args)
    {
        Employee emp = new Employee();
        Manager mgr = new Manager();


        /**
         * Assign data for Employee emp
         */
        emp.setName("Employee");
        emp.setAge("24");
        emp.setPhoneNumber("1234567891");
        emp.setAddress("Employee_Address");
        emp.setSalary("100000");
        emp.setDepartment(null);
        emp.setSpecialization(null);


        /**
         * Assign data for Manager mgr
         */
        mgr.setName("Manager");
        mgr.setAge("28");
        mgr.setPhoneNumber("1234567892");
        mgr.setAddress("Manager_Address");
        mgr.setSalary("150000");
        mgr.setDepartment(null);
        mgr.setSpecialization(null);

        /**
         * Print assigned data for emp and mgr
         */
        emp.getDetails(emp.getDepartment());
        mgr.getDetails(mgr.getDepartment());
    }
}
