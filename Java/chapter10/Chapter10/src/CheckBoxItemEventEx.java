// 시험
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxItemEventEx extends JFrame {
	private JCheckBox [] fruits = new JCheckBox [3]; // 체크박스 array로 생성
	private String [] names = {"사과", "배", "체리"}; 
	private JLabel sumLabel; // 계산 결과가 나오는 레이블
	
	public CheckBoxItemEventEx() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과  100원, 배 500원, 체리 20000원"));
		
	
		MyItemListener listener = new MyItemListener();
		for(int i=0; i<fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true); // 테두리 박스 추가
			c.add(fruits[i]); // 컨테이너에 추가
			fruits[i].addItemListener(listener); // 각각 프룻에 리스너 달기
		}
		
		sumLabel = new JLabel("현재 0 원 입니다.");
		c.add(sumLabel);
		
		setSize(250,200);
		setVisible(true);
	}
	
	// Item 리스너 구현
	class MyItemListener implements ItemListener {
		private int sum = 0; // 가격의 합
		
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) { // 
				if(e.getItem() == fruits[0]) // 사과
					sum += 100;
				else if(e.getItem() == fruits[1]) // 배
					sum += 500;
				else // 체리
					sum += 20000;
			}
			else { // 선택을 안한 경우
				if(e.getItem() == fruits[0])
					sum -= 100;
				else if(e.getItem() == fruits[1])
					sum -= 500;
				else
					sum -= 20000;				
			}
			sumLabel.setText("현재 "+sum+"원 입니다.");
		}
	}
	public static void main(String [] args) {
		new CheckBoxItemEventEx();
	}
} 