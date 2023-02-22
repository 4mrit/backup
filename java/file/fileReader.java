import java.io.FileReader;
import java.io.IOException;

public class fileReader
{
    public static void main (String [] args)
    {
        int data;
        try{
            FileReader reader_kto_mah = new FileReader("art.txt");
            data = reader_kto_mah.read();

            while(data != -1)
            {
                System.out.print( (char)data );
                data = reader_kto_mah.read();
            }

        }
        catch(IOException e)
        {
            e.printStackTrace(); //*? no clue what the fuck is this
        }
    }
}