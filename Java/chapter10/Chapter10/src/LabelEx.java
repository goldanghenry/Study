import javax.swing.*;
import java.awt.*;

public class LabelEx extends JFrame {
	public LabelEx() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		 // 문자열 레이블 생성
		JLabel textLabel = new JLabel("제임스 고슬링 입니더!");
		
		//이미지
		ImageIcon img = new ImageIcon("src/images/gosling.jpg");// 상대 경로		
		JLabel imageLabel = new JLabel(img); // 이미지 레이블 생성
		
		// 이미지+문자열
		ImageIcon icon = new ImageIcon("src/images/icon.gif");
		JLabel label = new JLabel("커피한잔 하실래예, 전화주이소", 
				icon, SwingConstants.CENTER);

		c.add(textLabel);
		c.add(imageLabel);		
		c.add(label);
		
		setSize(300,500);		
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new LabelEx();
	}
} 




