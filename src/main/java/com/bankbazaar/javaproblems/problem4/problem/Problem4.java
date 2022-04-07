package com.bankbazaar.javaproblems.problem4.problem;

import com.bankbazaar.javaproblems.problem4.model.SlowMethod;

public class Problem4 {
    public static void main(String[] args)
    {
        SlowMethod obj = new SlowMethod();

        /**
         * Print Slow method completed
         */
        obj.start();

        /**
         * print Waiting for slow method
         */
        System.out.println("Waiting for slow method");
    }
}
