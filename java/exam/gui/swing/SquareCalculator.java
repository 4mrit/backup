import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SquareCalculator implements ActionListener
{
    JFrame frame = new JFrame("swings");
    JLabel label1 = new JLabel("Enter any Number : ");
    JLabel label2 = new JLabel("Result : ");
    JButton factBtn = new JButton("Factorial");
    JButton sqrBtn = new JButton("Square");
    JTextField numTextField = new JTextField();
    JTextField sqrTextField = new JTextField();

    SquareCalculator(){   
        frame.setSize(600,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,2));

        frame.add(label1);
        frame.add(numTextField);
        frame.add(factBtn);
        frame.add(sqrBtn);
        frame.add(label2);
        frame.add(sqrTextField);

        factBtn.addActionListener(this);
        sqrBtn.addActionListener(this);
    }

    public static void main(String [] args){
        new SquareCalculator();
    }

    public void actionPerformed(ActionEvent e)
    {
        int result=0,input = Integer.parseInt(numTextField.getText());

        if(e.getSource() == sqrBtn)
            result = input*input;
        else //if (e.getSource() == factBtn)
            result = fact(input);

        sqrTextField.setText(Integer.toString(result));

    }
    int fact(int n)
    {
        if(n < 2)
            return 1;
        else
            return n*fact(n-1);
    }
}