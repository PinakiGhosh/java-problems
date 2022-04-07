package com.bankbazaar.javaproblems.problem4.model;

public class SlowMethod extends Thread
{
    public void run()
    {
        try
        {
            Thread.sleep(5000);
            System.out.println("Slow method completed");
        }
        catch (Exception e){}
    }
}