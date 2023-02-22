public class cube
{
    int length;
    int breadth;
    int height;


    cube( int l,int b,int h)
    {
        // this.length = length;
        // this.breadth = breadth;
        // this.height = height;
        
        this.length = l;
        this.breadth = b;
        this.height = h;
    }

    int vol()
    {
        return length*breadth*height;
    }

    int vol(int l,int b,int h)
    {
        return l*b*h;
    }
}