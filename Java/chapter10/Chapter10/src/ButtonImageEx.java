import javax.swing.*;
import java.awt.*;

public class ButtonImageEx extends JFrame {
	public ButtonImageEx() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// 3개의 이미지 아이콘 객체 생성
		ImageIcon normalIcon = new ImageIcon("src/images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("src/images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("src/images/pressedIcon.gif");		
		
		// 하나의 버튼에 부착
		JButton btn = new JButton("call~~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		c.add(btn);
		
		setSize(250,150);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new ButtonImageEx();
	}
}