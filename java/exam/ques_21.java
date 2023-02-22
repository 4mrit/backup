import java.io.*;
import java.util.Scanner;
public class ques_21 {
    public static void main(String[] args) throws IOException
    {
        Scanner scn = new Scanner(System.in);
        File emp = new File("Student.txt");

        emp.createNewFile();
        String str;

        Scanner empScanner = new Scanner(emp);
        FileWriter empWriter = new FileWriter(emp);

        System.out.println("Enter employee id :  ");
        empWriter.write(scn.nextInt() + "\n");
        scn.next();
        System.out.println("Enter your name :  ");
        empWriter.write(scn.nextLine() + "\n");
        System.out.println("Enter your address :  ");
        empWriter.write(scn.nextLine() + "\n");
        System.out.println("Enter your DOB   :  ");
        empWriter.write(scn.next() + "\n");
        System.out.println("Enter your phone no :  ");
        empWriter.write(scn.nextInt() + "\n");

        empWriter.close();
        str = empScanner.nextLine();
        while(str != null )
        {
            System.out.println( empScanner.nextLine());
            str = empScanner.nextLine();
        }
        empScanner.close();
        scn.close();
  }
}

 