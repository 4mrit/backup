class queue
{
    int array[],size;
    int rear,front=-1;
    queue(int size)
    {
        array = new int[size];
        this.size = size;
    }
    void display()
    {
        for(int i=0;i<size; i++)
        {
            if( !(i>front) && !(i < rear))
            {
                System.out.print(array[i] + " | ");
            }
            System.out.print("  | ");
        }
        System.out.println();
    }

}

public class DEQueue
{
    public static void main (String [] args)
    {
        queue q = new queue(6);
        q.display();
    }
}