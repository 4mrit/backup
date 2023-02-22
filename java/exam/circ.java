class queue
{
    int array[],size;
    int rear = -1,front=-1;
    queue(int size)
    {
        array = new int[size];
        this.size = size;
    }
    boolean isEmpty()
    {
        if(rear < front || front == -1)
            return true;
        return false;
    }
    boolean isFull()
    {
        if((rear+1)%size == front)
            return true;
        return false;
    }
    void display()
    {
        for(int i=0;i<size; i++)
        {
            if(i>=front || i<=rear) 
            {
                System.out.print( " | "+ array[i] );
            }
            else 
            {
                System.out.print(" |  ");
            }
        }
        System.out.println(" |");
    }

    void enque(int x)
    {
        if(isFull())
        {
            System.out.println("Queue Overflow!!");
        }
        else
        {
            rear= (rear+1)%(size);
            array[rear] = x;

            front = front==-1 ? 0 :front; // if front == -1 make front 1
        }
    }
    int deque()
    {
        if(isEmpty())
        {
            System.out.println("queue is empty");
            return 0;
        }
        else
        {
            int item =  array[front];
            front ++ ;
            return item;
        }
    }
}

public class circ
{
    public static void main (String [] args)
    {
        queue q = new queue(6);
        // q.display();
        q.enque(111);
        q.enque(222);
        q.enque(333);
        q.enque(444);
        q.enque(555);
        q.enque(666);
        q.display();
        q.deque();
        q.display();
        q.enque(777);
        q.display();
    }
}