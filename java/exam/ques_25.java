import java.io.*;
import java.util.Scanner;

public class ques_25 {
    public static void main(String[] args) throws IOException
    {
        Scanner scn = new Scanner(System.in);
        File student = new File("Student.txt");
        File pupil = new File("Pupil.txt");

        student.createNewFile();
        pupil.createNewFile();

        Scanner studentScanner = new Scanner(student);
        FileWriter studentWriter = new FileWriter(student);
        FileWriter pupilWriter = new FileWriter(pupil);

        System.out.println("Enter your name :  ");
        studentWriter.write(scn.nextLine() + "\n");
        System.out.println("Enter your address :  ");
        studentWriter.write(scn.nextLine() + "\n");
        System.out.println("Enter your college :  ");
        studentWriter.write(scn.nextLine() + "\n");

        studentWriter.close();

        pupilWriter.write( studentScanner.nextLine() + "\n" );
        pupilWriter.write( studentScanner.nextLine() + "\n" );
        pupilWriter.write( studentScanner.nextLine() + "\n");

        pupilWriter.close();
        scn.close();
  }
}

