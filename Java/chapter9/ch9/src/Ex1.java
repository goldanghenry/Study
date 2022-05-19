import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ex1 extends JFrame {
    public Ex1(){
        setTitle("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        //--------------------------------------
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyTest());
        c.add(btn);

        //--------------------------------------
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Ex1();
    }
}
class MyTest implements ActionListener{
    public void actionPerformed(ActionEvent e){
        JButton b = (JButton)e.getSource();
        if(b.getText().equals("Action")) b.setText("액션");
        else b.setText("Action");
    }
}