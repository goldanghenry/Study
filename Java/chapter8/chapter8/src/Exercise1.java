import javax.swing.*;
import java.awt.*;

public class Exercise1 extends JFrame{
    public Exercise1(){   
        setTitle("Border Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane(); // return type is Container
        c.setLayout(new BorderLayout(5,5));  // 반드시 템플릿에 넣어주어야 한다.

        // To do -------------------------------
        c.add(new JButton("Menu"), BorderLayout.NORTH);
        c.add(new JButton("Console"), BorderLayout.SOUTH);
        c.add(new JButton("Editor"), BorderLayout.CENTER);
        c.add(new JButton("div"), BorderLayout.WEST);


        // -------------------------------
        setSize(300,300);
        setVisible(true); 
    }
    public static void main(String[] args) {
        new Exercise1();
    }
}
