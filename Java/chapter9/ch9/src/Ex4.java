// 익명클래스 변환 시험 나옴
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ex4 extends JFrame {
    private JLabel la = new JLabel("Hello");
    public Ex4(){
        setTitle("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        //--------------------------------------
        c.addMouseListener(new MyMouseListener());
        la.setSize(200,200);
        la.setLocation(30,30);
        c.add(la);
        //--------------------------------------
        setSize(300, 300);
        setVisible(true);
    }
    class MyMouseListener implements MouseListener {
        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);            
        }
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
    }
    public static void main(String[] args){
        new Ex4();
    }
}
