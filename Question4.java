//slowMethod class
class slowMethod extends Thread
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

public class Question4 {
    public static void main(String[] args)
    {
        slowMethod obj = new slowMethod();

        //Print "Slow method completed"
        obj.start();

        //Print "Waiting for slow method"
        System.out.println("Waiting for slow method");
    }
}
