import java.util.Scanner;
public class trngle
{
    public static void main (String [] args)
    {
        Scanner scn = new Scanner(System.in);
        double x,y,z;
        System.out.println("Enter perpendicular :");
        x= scn.nextDouble();
        System.out.println("Enter base :");
        y= scn.nextDouble();

        z= Math.sqrt(   (x*x)   +   (y*y)   );

        System.out.println("Hypotenuse is "+z);

    }
}