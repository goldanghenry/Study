// 익명클래스 변환 시험 나옴
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ex2 extends JFrame {
    public Ex2(){
        setTitle("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        //--------------------------------------
        JButton btn = new JButton("Action");
        c.add(btn);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Action")) 
                    b.setText("액션");
                else 
                    b.setText("Action");
                    setTitle(b.getText());
            }
        });
        

        //--------------------------------------
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args){
        new Ex2();
    }
}