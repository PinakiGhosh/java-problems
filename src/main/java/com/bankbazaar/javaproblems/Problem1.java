package com.bankbazaar.javaproblems;

public class Problem1 {
    public static void main(String[] args)
    {
        Employee emp = new Employee();
        Manager mgr = new Manager();


        /**
         * Assign data for Employee emp
         */
        emp.name="Employee1";
        emp.age="24";
        emp.phoneNumber="1234567891";
        emp.address="Employee_Address";
        emp.salary="100000";


        /**
         * Assign data for Manager mgr
         */
        mgr.name="Manager1";
        mgr.age="30";
        mgr.phoneNumber="1234567892";
        mgr.address="Manager_Address";
        mgr.salary="150000";

        /**
         * Print assigned data for emp and mgr
         */
        emp.getDetails(emp.department);
        mgr.getDetails(mgr.department);
    }
}
