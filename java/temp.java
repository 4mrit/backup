public class temp
{
    public static void main (String [] args)
    {
        C c = new C();
    }
}
class A 
{
    A()
    {
        System.out.println("Const A");
    }
}
class B extends A
{
    B()
    {
        System.out.println("Const B");
    }
}
class C extends B
{
    C()
    {
        System.out.println("Const C");
    }
}