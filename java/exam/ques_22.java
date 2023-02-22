class Rectangle {
    int length,breadth;

    Rectangle(int length,int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    int computeArea() {
        return length*breadth;
    }

    void displayArea(){
        System.out.println("Area is "+ (length*breadth));
    }
}

public class ques_22
{
    public static void main (String [] args){

        Rectangle r1 = new Rectangle(33,22);
        Rectangle r2 = new Rectangle(1,100);
        int a1 = r1.computeArea();
        int a2 = r2.computeArea();

        if(a1>a2) {
            r1.displayArea();
        } else {
            r2.displayArea();
        }
    }
}




