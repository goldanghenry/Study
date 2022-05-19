import javax.swing.*;
import java.awt.*;

public class Exercise2 extends JFrame{
    public Exercise2(){   
        setTitle("Panel Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane(); 
        c.setLayout(new BorderLayout()); 

        // To do -------------------------------
        JPanel JP = new JPanel();
        JP.setLayout(new GridLayout(1,2,5,5));
        JP.add(new JButton("test"));

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,1,5,5));
        p.add(new JButton("test1"));
        p.add(new JButton("test2"));
        JP.add(p);

        c.add(JP, BorderLayout.SOUTH);
        // -------------------------------
        setSize(300,200);
        setVisible(true); 
    }
    public static void main(String[] args) {
        new Exercise2();
    }
}
