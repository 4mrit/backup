import java.awt.*;
import javax.swing.*;
public class panelDemo
{
`    {
        JFrame frame = new JFrame("swings");
        frame.setSize(420,420);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);
        panel1.setBounds(0,0,250,250);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        panel2.setBounds(250,250,250,250);

        frame.add(panel1);
        frame.add(panel2);
    }
}