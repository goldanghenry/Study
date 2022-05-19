// 익명클래스 변환 시험 나옴
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class practice2_1 extends JFrame {
    private JLabel keyJLabels[];

    public practice2_1(){
        setTitle("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,3));
        //--------------------------------------
        // JButton
        keyJLabels = new JLabel[12];
        MyMouseListener myMouseListener[] = new MyMouseListener[12];
        for (int i=0; i<12; i++){
            keyJLabels[i] = new JLabel(Integer.toString(i));
            keyJLabels[i].setOpaque(true);
            keyJLabels[i].setBackground(new Color(255,255,255));
            c.add(keyJLabels[i]);
            myMouseListener[i] = new MyMouseListener();
            keyJLabels[i].addMouseListener(myMouseListener[i]);
        }
        
        //--------------------------------------
        setSize(300, 300);
        setVisible(true);
    }
    class MyMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            JLabel label2 = (JLabel)e.getSource();
            // 임의의 색을 만들기 위해 랜덤하게 r,g,b 성분 생성
            int r = (int)(Math.random()*256);   // red
            int g = (int)(Math.random()*256);   // green
            int b = (int)(Math.random()*256);   // blue
            label2.setBackground(new Color(r,g,b));
        }
    }
    public static void main(String[] args){
        new practice2_1();
    }
}
