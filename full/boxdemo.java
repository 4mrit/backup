public class boxdemo
{
    public static void main(String[] args)
    {
        Box box1 = new Box();
        Box box2 = new Box();

        box1.length= 73;
        box1.width = 43;
        box1.height = 68;

        box2.length = 79;
        box2.width = 68;
        box2.height = 79;

        double vol1= box1.volume();
        double vol2= box2.volume();

        System.out.println("The volume of first Box is " + vol1);
        System.out.println("The volume of Second Box is " + vol2);
    }
}

class Box
{
    double width;
    double height;
    double length;

    double volume()
    {
        return width*length*height;
    }
}
