// 익명클래스 변환 시험 나옴
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class practice2 extends JFrame {

    public practice2(){
        setTitle("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,3));
        //--------------------------------------
        for (int i=0; i<12; i++){
           String text = Integer.toString(i);
           JLabel la = new JLabel(text);
           la.setBackground(Color.WHITE);
           la.setOpaque(true);
           la.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                JLabel label2 = (JLabel)e.getSource();
                // 임의의 색을 만들기 위해 랜덤하게 r,g,b 성분 생성
                int r = (int)(Math.random()*256);   // red
                int g = (int)(Math.random()*256);   // green
                int b = (int)(Math.random()*256);   // blue
                label2.setBackground(new Color(r,g,b));
                };
           });
           c.add(la);
        }
        
        //--------------------------------------
        setSize(300, 300);
        setVisible(true);
    }
    class MyMouseListener extends MouseAdapter {
        
    }
    public static void main(String[] args){
        new practice2();
    }
}
