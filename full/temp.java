public class temp
{
    public static void main (String [] args)
    {
          
    }
}

class student
{
   int roll_no;

    student(int roll)
    {
        this.roll_no = roll;
    }

    void displayRoll()
    {
        System.out.println("Roll no :"+roll_no);
    }

}

class Test extends student
{
    int m1,m2;

    Test(int roll,int m1,int m2)
    {
        super(roll);
        this.m1 = m1;
        this.m2 = m2;
    }

    void displayMarks()
    {
        System.out.println("Mark 1 :"+m1);
        System.out.println("Mark 2 :"+m2);

    }
}

class Result extends Test
{
    int total;
    Result(int roll,int m1,int m2)
    {
        super(roll,m1,m2);
        total=m1+m2;
    }
    int calculateTotal()
    {
        return total;
    }
    void displayTotal()
    {
        System.out.println("Total is "+total);
    }
}