// 버튼을 클릭하면 바탕을 버튼의 색상으로 수정.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice extends JFrame{
private Container c = getContentPane();
private JButton yellow;
private JButton red;

    public practice(){
        setTitle("버튼 액션 이벤트 처리");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,2));

        MyBTNListener listener = new MyBTNListener();
        yellow = new JButton("노랑");
        red = new JButton("빨강");
        yellow.addActionListener(listener);
        yellow.addActionListener(listener);
        p.add(yellow);
        p.add(red);
        c.add(p, BorderLayout.SOUTH);


        setSize(250,200);
		setVisible(true);
    }

    class MyBTNListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            String cmd = e.getActionCommand();
            if(b.getText().equals("노랑"))
                c.setBackground(Color.YELLOW);
            else if(cmd.equals("빨강"))
                c.setBackground(Color.RED);
        }
    }
    public static void main(String[] args){
        new practice();
    }
}
