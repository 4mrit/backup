public class Car
{
    String name;
    int year;

    Car(String name , int year)
    {
        this.setName(name);
        this.setYear(year);
    }
    Car(Car x)
    {
        this.copy(x);
    }

    void copy(Car x)
    {
        this.setName ( x.getName() );
        this.setYear ( x.getYear() );
    }







    //getter and setters
    String getName()
    {
        return this.name;
    }
    int getYear()
    {
        return this.year;
    }
    void setName(String name)
    {
        this.name = name;
    }
    void setYear(int year)
    {
        this.year = year;
    }

}