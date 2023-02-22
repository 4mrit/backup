class hi implements Runnable
{
    public void run ()
    {
        //buisness logic 
    }
}
public class runnable_demo extends Thread
{
    public static void main (String [] args)
    {
        hi obj1 = new hi();
        Thread t = new Thread(obj1);
        t.start();
    }
}