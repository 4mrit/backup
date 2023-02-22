import java.util.Scanner;
public class stack_demo
{
    public static void main (String [] args)
    {
        char scn_exp;
        Scanner scn = new Scanner(System.in);
        char_stack stack = new char_stack(5);
        String postfix=" ", user_input  = scn.next();

        for(int i = 0 ; i < user_input.length() ; i++)
        {
            scn_exp = user_input.charAt(i);
            System.out.print(scn_exp);

            if( IsSymbol(scn_exp) )
            {
                postfix += scn_exp;
            }
            else if (scn_exp == '(')
            {
                stack.push(scn_exp)
            }



        }

    }

    static boolean IsSymbol(char a)
    {
        if (a == '+' || a == '-' || a =='*' || a== '/' || a=='^' || a == '$')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}