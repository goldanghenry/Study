// 익명클래스 변환 시험 나옴
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class practice1 extends JFrame {
    public practice1(){
        setTitle("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        //--------------------------------------
        JButton btn1 = new JButton("Button1");
        JButton btn2 = new JButton("Button2");
        MyAction MyAction = new MyAction();
        btn1.addActionListener(MyAction);
        btn2.addActionListener(MyAction);
        c.add(btn1);
        c.add(btn2);

        //--------------------------------------
        setSize(300, 300);
        setVisible(true);
    }
    class MyAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
           JOptionPane.showMessageDialog(null, "You Pressed: " + e.getActionCommand());
        }
    }
    public static void main(String[] args){
        new practice1();
    }
}
