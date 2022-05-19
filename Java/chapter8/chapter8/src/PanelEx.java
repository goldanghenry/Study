import javax.swing.*;
import java.awt.*;

public class PanelEx extends JFrame{
    public PanelEx(){   
        setTitle("배치관리자 없이 절대 위치에 배치하는 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane(); 
        c.setLayout(new BorderLayout()); 

        // To do -------------------------------
        JPanel p = new JPanel();
        JLabel l1 = new JLabel("text1");
        JLabel l2 = new JLabel("text2");

        p.setLayout(new GridLayout(1,2,5,5));
        p.add(l1);
        p.add(l2);
        c.add(p, BorderLayout.SOUTH);

        // -------------------------------
        setSize(300,200);
        setVisible(true); 
    }
    public static void main(String[] args) {
        new PanelEx();
    }
}
