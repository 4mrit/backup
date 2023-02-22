public class method_overriding
{
    public static void main (String [] args)
    {
        wolf w1 = new wolf();
        wolf.speak();  // uses the specific overridden metthon in wolf class

    }
}
class animal
{
    void speak()
    {
       
        System.out.println("animal made sound");
    }
}

class wolf extends animal
{
    @Override
    void speak()
    {
        System.out.println(" * WOOF WOOF * ");
    }
}