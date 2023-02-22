import java.util.Scanner;

public class main
{
    public static void main (String [] args)
    {

        int l,b,h;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter length breadth and height");
        l=scanner.nextInt();
        b=scanner.nextInt();
        h=scanner.nextInt();

        cube c1 = new cube(l,b,h);
        cube c2 = new cube(l,b,h);

        int v1=c1.vol(1,2,3);
        int v2=c1.vol(2,3,4);

        System.out.println("volume is "+ c1.vol());


    }
}