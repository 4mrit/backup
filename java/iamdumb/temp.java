import java.util.Scanner;
public class temp
{
    public static void main (String [] args)
    {
         Stack S = new Stack(99);
         S.push("99");
         S.push("69");
         S.push("0000");
         System.out.println(S.peek());
         System.out.println(S.peek());
         System.out.println(S.pop());
         System.out.println(S.pop());
         System.out.println(S.pop());
         System.out.println(S.pop());

    }
}