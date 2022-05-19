import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame{
    public ContentPaneEx(){   
        setTitle("300x300 스윙 프레임 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane(); // return type is Container
        c.setLayout(new FlowLayout());  // 반드시 템플릿에 넣어주어야 한다.

        // To do -------------------------------
        c.setBackground(Color.ORANGE);
        c.add(new JButton("OK"));    // add를 visible 아래에 하면 나타나지 않는다.
        c.add(new JButton("Cancle"));
        c.add(new JButton("Ignore"));        


        // -------------------------------
        setSize(300,300);
        setVisible(true); 
    }
    public static void main(String[] args) {
        new ContentPaneEx();
    }
}
