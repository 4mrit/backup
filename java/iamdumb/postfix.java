import java.util.Scanner;
public class postfix
{
    public static void main (String [] args)
    {

        Scanner scanner = new Scanner(System.in);    
        String user_input,stack="(",final_expression=" ";
        char scanned,s_v;

        //asking user for the expression
        System.out.println("Enter your infix expression :");
        user_input = scanner.next() + ")";
        int stack_pointer=0;
        for (int i = 0; i < user_input.length(); i++)
        {
            scanned= user_input.charAt(i);
            if(Character.isLetter(scanned) || scanned=='(') 
            {
                final_expression += scanned;
            }
            else if(scanned == '+' || scanned == '-' || scanned == '*'|| scanned == '/' || scanned == '$' || scanned =='^')    
            {
                while(true)
                {
                    s_v = stack.charAt(stack_pointer);
                    stack_pointer--;
                    if( ((s_v=='$' || s_v == '^') && (scanned=='/' || scanned == '*')) || ((scanned=='/' || scanned == '*') && (scanned=='+' || scanned == '-')) )
                    {
                        final_expression += s_v;
                        break;
                    }
                    else if(stack_pointer == 0)
                    {
                        break;
                    }
                    else
                    {
                        final_expression += s_v;
                    }
                    
                }
            }
            else if(scanned == ')')
            {
                while(true)
                {
                    s_v = stack.charAt(stack_pointer);
                    stack_pointer--;
                    final_expression += s_v;
                    if(s_v == '(')
                    {
                        break;
                    }
                }

            }
        }

        System.out.println(final_expression);


        
        

        scanner.close();
    }
}