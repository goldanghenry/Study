import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame{
    public BorderLayoutEx(){   
        setTitle("예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane(); // return type is Container
        c.setLayout(new BorderLayout(30,20));  // 반드시 템플릿에 넣어주어야 한다.

        // To do -------------------------------
        c.setBackground(Color.ORANGE);
        c.add(new JButton("Calculate"), BorderLayout.CENTER);    // add를 visible 아래에 하면 나타나지 않는다.
        c.add(new JButton("add"), BorderLayout.NORTH);
        c.add(new JButton("sub"), BorderLayout.SOUTH);
        c.add(new JButton("mul"), BorderLayout.EAST);
        c.add(new JButton("div"), BorderLayout.WEST);


        // -------------------------------
        setSize(300,200);
        setVisible(true); 
    }
    public static void main(String[] args) {
        new BorderLayoutEx();
    }
}
