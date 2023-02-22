public class copy
{
    public static void main (String [] args)
    {
        Car c1 = new Car("Audi" , 2020);
        Car c2 = new Car("rand" , 1);

        System.out.println("ADD: "+c1 +"  Name : " + c1.getName() + "    Year : " +  c1.getYear());
        System.out.println("ADD: "+c2 +"  Name : " + c2.getName() + "    Year : " +  c2.getYear());
        System.out.println();

        c2.copy(c1);
        System.out.println("ADD: "+c2 +"  Name : " + c2.getName() + "    Year : " +  c2.getYear());
        System.out.println();
        

        Car c3 = new Car(c1);
        System.out.println("ADD: "+c3 +"  Name : " + c3.getName() + "    Year : " +  c3.getYear());


    }
}