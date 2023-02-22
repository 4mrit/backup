import java.util.Scanner;
import java.util.InputMismatchException;
public class main
{
    public static void main (String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int x,y,z;
        System.out.println("Enter two whole number");


        try
        {
            x = scanner.nextInt();
            y = scanner.nextInt();
            z = x/y;
            System.out.println("Result : "+z);
        }        
        catch(InputMismatchException a)
        {
            System.out.println("You are supposed to enter whole numbers dumass!");

        }
        catch(ArithmeticException a)
        {
            System.out.println("AYO LOOK A STUPID ASS TRYING TO DIVIDE BY ZERO!");
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
        finally
        {
            System.out.println("This will always run !");
            scanner.close();
        }
    }
}