import java.io.*;
class employee implements Serializable{
    int age;
}
public class deseril
{
    public static void main (String [] args) throws Exception
    {
        employee e;

        File data = new File("data.emp");

        FileInputStream fo = new FileInputStream(data);
        ObjectInputStream in = new ObjectInputStream(fo);

        e = (employee) in.readObject();
        System.out.println("dad -> " + e.age);

    }
    
}