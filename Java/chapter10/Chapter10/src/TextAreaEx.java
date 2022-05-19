import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TextAreaEx extends JFrame {
	private JTextField tf = new JTextField(20);
	private JTextArea ta = new JTextArea(7, 20);
	
	public TextAreaEx() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		c.add(tf);
		c.add(new JScrollPane(ta));
		
		// 텍스트필드에 action 리스너를 등록
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource(); // 액션 이벤트 발생한 곳 리턴
				ta.append(t.getText() + "\n"); // t의 text를 가져와서 ta에 append. <한줄 띄우기>
				t.setText(""); // 텍스트필드 리셋
			}
		});
		
		setSize(300,250);
		setVisible(true);
	}
		
	public static void main(String [] args) {
		new TextAreaEx();
	}
}