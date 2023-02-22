import java.util.Scanner;

public class final_postfix
{
    public static void main (String [] args)
    {
        // Q == infix expression   P = postfix expression     S = Stack   s_p = stack pointer

        String S="(",P=" ",Q = new String();
        char scn;
        int s_p = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your infix expression without spaces : ");
        Q= scanner.next() +')';
        
        System.out.println("\n\nScanned Symbol \t|\tStack\t|\tPostfix Ecpression\t|");
        System.out.println("--------------- | ------------- | ----------------------------- |");





        for(int i = 0; i < Q.length(); i++)
        {
            scn = Q.charAt(i);

            System.out.printf("%d|%10c\t|\t%5s\t|\t%20s\t|\n",s_p,scn,S,P);




            if(Character.isLetter(scn))     //push operand  directly to output
            {
                P += scn;
            }   


            else if(scn == '(')         // push open parenthesis directly to stack
            {
                S += scn;
                s_p ++;
            }

            else if(scn == ')')
            {
                while ( S.charAt(s_p) != '(' )
                {


                    P += S.charAt(s_p);
                    S= S.substring(0, s_p);
                    s_p--;
                }
                S= S.substring(0, s_p);
                s_p--;
            }


             else if(scn == '+' || scn =='-' || scn == '*' || scn =='/' || scn == '^' || scn == '$')
            {
                if( (comp(scn,  S.charAt(s_p)) == 1) ) //if precedence is lower than TOS or TOS is open parenthesis push scanned symbol directly to stack
                {
                    S += scn;
                    s_p++;
                }
                else
                {
                    while (  comp(scn, S.charAt(s_p)) != 1 )
                    {
                        P += S.charAt(s_p);
                        S= S.substring(0, S;
                        s_p--;
                        
                    }
                    S += scn;
                    s_p++;
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