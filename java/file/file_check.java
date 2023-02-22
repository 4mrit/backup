import java.io.File;
public class file_check
{
    public static void main (String [] args)
    {
        File file = new File("secret.txt");
        if(file.exists())
        {
            System.out.println("The file exists");
        }
    }
}