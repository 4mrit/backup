class hi extends Thread
{
    public void run()
    {
        for ( int i =1;i <=5 ; i++)
        {
            System.out.println("Hi");
            
        }
    }
}
public class ThreadDemo extends Thread
{
    public static void main (String [] args)
    {
        hi obj1 = new hi();

    }
}