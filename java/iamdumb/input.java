import java.util.Scanner;

public class main
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Whats your name");
        String name = scn.nextLine();
        System.out.println("age ?");
        int age = scn.nextInt();
        System.out.println("fav food ?");
        scn.nextLine();
        String food = scn.nextLine();
        System.out.println("your name is : " + name);
        System.out.println("you are "+age+" years old.");
        System.out.println("you like "+food);
    }
}