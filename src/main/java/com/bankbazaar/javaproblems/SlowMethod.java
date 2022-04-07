package com.bankbazaar.javaproblems;

class SlowMethod extends Thread
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