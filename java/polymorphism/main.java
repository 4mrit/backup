public class main
{
    public static void main (String [] args)
    {
        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Boat boat = new Boat();

        Vechile[] array = {car,bicycle,boat}; // car identifies as data type Car,Vechicle,Object
        Object[] arr = {car,bicycle,boat}; // *! no clue how to make it work

        for(Vechile x: array)
        {
            x.go();
        }
        

        for(Object o: arr)
        {
            o.go();
        }
    }
}