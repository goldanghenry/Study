import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ComboActionEx extends JFrame {
	private String [] fruits = {"apple", "banana", "mango"}; 
	private ImageIcon [] images = { new ImageIcon("src/images/apple.jpg"), 	
							new ImageIcon("src/images/banana.jpg"), 
							new ImageIcon("src/images/mango.jpg") };
	private JLabel imgLabel = new JLabel(images[0]); 
	
	public ComboActionEx() {
		setTitle("콤보박스 활용 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JComboBox<String> combo = new JComboBox<String>(fruits); 
		c.add(combo); c.add(imgLabel);

		// 콤보박스에 Action 리스너 등록, 선택된 아이템의 이미지 출력
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JComboBox<String> cb = (JComboBox<String>)e.getSource();  
				// int index = cb.getSelectedIndex();
				// imgLabel.setIcon(images[index]); 
			}
		});
		
		setSize(300,250);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new ComboActionEx();
	}
}


