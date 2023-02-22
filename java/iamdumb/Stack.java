public class Stack
{   
    public static int size,index;
    String[] arr;
    public Stack(int size)
    {
        this.size = temp_size;
        this.arr = new String[size];
    }


    void push(String temp_string)
    {
        if(this.index != (size -1) )
        {
            this.arr[this.index]=temp_string;
            this.index++;
        }
    }

    String pop()
    {
        if(this.index !=0)
        {
            this.index--;
            return arr[this.index];
        }
        else
        {
            return "stack is empty!!";
        }
    }

    String peek()
    {
        if(this.index !=0)
        {
            return this.arr[this.index -1];
        }
        else
        {
            return "stack is empty!!";
        }
    }

    boolean isEmpty()
    {
        System.out.println(this.index);
        if(this.index > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    boolean isFull()
    {
        if(this.index ==this.size-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    void display()
    {
        for (int i = 0; i < arr.length; i++) {
            if(thuarr[i] == null)
            {
                break;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}