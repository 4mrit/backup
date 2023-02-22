import java.io.FileWriter;
import java.io.IOException;
public class file_writer
{
    public static void main (String [] args)
    {
        try
        {
            FileWriter writer  = new FileWriter("secret.txt");
            writer.append("bruh");
            writer.close();
        }
        catch(IOException a)
        {
            e.printStackTrace(); //*? no clue what the fuck is this
        }
}
 