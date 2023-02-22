import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;
public class post_with_stack
{
    public static void main (String [] args)
    {
        // Q == infix expression   P = postfix expression     S = Stack   s_p = stack pointer
        String P=" ",Q = new String();
        char scn,tos;
        int s_p = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your infix expression without spaces : ");
        Q= scanner.next() + ')';
        Stack S = new Stack(Q.length()+1);
        
        System.out.println("\n\nScanned Symbol \t|\tStack\t|\tPostfix Ecpression\t|");
        System.out.println("--------------- | ------------- | ----------------------------- |");
        for(int i = 0; i < Q.length(); i++)
        {
            scn = (String)Q.charAt(i);
            System.out.printf("%10c\t|\t%5s\t|\t%20s\t|\n",scn,S,P);


            if(Character.isLetter(scn))     //push operand  directly to output
            {
                P += scn;
            }   


            else if(scn == '(')         // push open parenthesis directly to stack
            {
                S.push(scn);
            }

            else if(scn == ')')
            {
                while ( S.peek() != '(' )
                {
                    P += S.pop();
                }
                S.pop();
            }


             else if(scn == '+' || scn =='-' || scn == '*' || scn =='/' || scn == '^' || scn == '$')
            {
                if( (comp( S.peek() , scn) == 1) ) //if precedence is lower than TOS or TOS is open parenthesis push scanned symbol directly to stack
                {
                    S.push(scn);
                }
                else
                {
                    while ( comp( S.peek() , scn) != 1 )
                    {
                        P += S.pop();
                    }
                    S.push(scn);
                }
            }



            else
            {
                System.out.println("invalid");
                System.exit(0);
            }

        }
        System.out.printf("%10c\t|\t%5s\t|\t%20s\t|\n",1,S,P);

    }




    //function t0 check presedence of operators;
    static int comp(char a , char b)
    {
        if(a == '(')
        {
            return 1;
        }
        else if(a == '$' || a == '^')
        {

            if(b== '$' || b =='^')
            {
                return 0;
            }
            else{
                return 1;
            }
        }
        else if(a == '-' || a== '+')
        {
            if(b == '-' || b=='+')
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
        else
        {
            if(b=='+' || b =='-')
            {
                return 1;
            }
            else if(b== '$' || b =='^')
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }
        


}