import java.io.*;
// import java.file;
// 
class employee implements Serializable
{
    int age = 1;
}
public class seril
{
    public static void main (String [] args) throws IOException
    {
        employee e = new employee();
        e.age = 6;

        File data = new File("data.emp");
        data.createNewFile();
        FileOutputStream fo = new FileOutputStream(data);
        ObjectOutputStream out = new ObjectOutputStream(fo);

        out.writeObject(e);
    }
    
}