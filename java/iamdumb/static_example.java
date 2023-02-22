public class static_example
{
    public static void main (String [] args)
    {
        System.out.println(obj.no_of_obj);
        
        obj f1 = new obj();
        obj f2 = new obj();
        obj f3 = new obj();
        obj f4 = new obj();

        System.out.println(obj.no_of_obj);
     }

    
}

class obj
{
    static int no_of_obj;
    obj()
    {
        no_of_obj++;
    }
}