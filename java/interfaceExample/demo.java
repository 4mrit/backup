public class demo
{
    public static void main (String [] args)
    {
        fish f = new fish();
        rabbit r = new rabbit();
        tiger t = new tiger();

        r.running();    //implementd prey
        System.out.println();

        t.hunting();    //implemted hunter
        System.out.println();



        //implemented both prey and hunter for fish
        f.hunting();    
        f.running();

    }
}