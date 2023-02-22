public class ThreadDemo extends Thread
{
    public static void main(String [] args)
    {
        ThreadDemo t1 = new ThreadDemo(1);
        ThreadDemo t2 = new ThreadDemo(2);
        t1.start();
        t2.start();
    } 

    private int threadNo;
    ThreadDemo(int threadNo){
        this.threadNo = threadNo;
    }

    public void run()
    {
        for(int i = 0 ; i <3 ; i++)
        {
            System.out.println(i +" from thread: " + threadNo/2);
            try{
             Thread.sleep(1000);
            }catch(Exception e){}
        }
    }
}