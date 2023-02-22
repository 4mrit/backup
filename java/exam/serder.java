import java.io.*;
public class serder
{
    public static void main (String [] args) throws IOException,ClassNotFoundException
    {   
        human h1 = new human();
        h1.name = "amrit";

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("human_data.emp"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("human_data.emp"));

        out.writeObject(h1);
        out.close();

        human h2 = (human) in.readObject();
        in.close();

        System.out.println("H2 name : "+ h2.name);
    }
}
class human implements Serializable
{
    String name;
}