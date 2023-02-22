import java.util.Scanner;
public class main
{
    public static void main (String [] args)
    {
        Scanner scn = new Scanner(System.in);
        animal myAnimal;
        System.out.println("What animal do you Choose ??");
        System.out.print(" ( 1 - Dog ) (2 - Cat ) : ");
        int choice  = scn.nextInt();

        if  (choice == 1)
        {
            myAnimal  = new dog();
        }

        else if(choice  == 2)
        {   
            myAnimal = new cat();
        
        }   
        else
        {
            System.out.println("Invalid option selected");
            myAnimal = new animal();
        }


        myAnimal.makeSound();
    }
}