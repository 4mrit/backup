// import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class basic
{
    public static void main(String [] args)
    {
        JFrame frame = new JFrame("swings");
        JLabel label = new JLabel("00000000");
        // label.setText("Broooo");

        // frame.setSize(420,420);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        // frame.pack();
    }
}