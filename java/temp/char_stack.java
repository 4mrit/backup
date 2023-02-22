public class char_stack
{
    int size;
    int tos;
    char [] stack;

    char_stack(int size)
    {
        tos = 0;
        this.size = size;
        stack = new char[size];
    }

    void push(char ch)
    {
        if( tos < size )
        {
            stack[tos] = ch;
            tos ++;
        }
    }

    char pop()
    {
        if(this.tos != 0)
        {
            this.tos --;
            return stack[this.tos];
        }
        return ' ';
    }


    char peek()
    {
        if(this.tos != 0)
        {
            return stack[this.tos];
        }
        return ' ';
    }



    void display()
    {
        System.out.print("Stack -> ");
        for(int i = 0 ; i < this.tos; i++)
        {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}V
        {
            return stack[this.tos];
        }
        return ' ';
    }



    void display()
    {
        System.out.print("Stack -> ");
        for(int i = 0 ; i < this.tos; i++)
        {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}