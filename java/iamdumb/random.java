import java.util.Random;
public class random
{
    public static void main (String [] args)
    {
        Random rand = new Random(); 
        int x = rand.nextInt(6)+1;
        System.out.println(x);
    }
}