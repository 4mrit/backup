import java.io.*;
public class fileBasic
{
    public static void main(String [] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("Student.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("Student.txt"));

        writer.write("Writin to file\nNew Line");
        writer.close();

        String data;
        while( (data=reader.readLine()) != null )
            System.out.println(data);

        reader.close();
    }
}