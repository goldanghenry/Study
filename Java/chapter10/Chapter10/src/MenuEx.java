import javax.swing.*;

public class MenuEx extends JFrame {
	public MenuEx() {
		setTitle("Menu 만들기 예제");
		createMenu(); // 메뉴 생성, 프레임에 삽입
		setSize(250,200);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar(); // 상단 메뉴바
		JMenu screenMenu = new JMenu("Screen"); // Screen 스크린 메뉴

		// Screen 메뉴에 아이템 추가
		screenMenu.add(new JMenuItem("Load"));
		screenMenu.add(new JMenuItem("Hide"));
		screenMenu.add(new JMenuItem("ReShow"));
		screenMenu.addSeparator(); // 구분 Line 넣기
		screenMenu.add(new JMenuItem("Exit"));

		// 메뉴바에 메뉴 붙이기
		mb.add(screenMenu); 
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Run"));

		// JMenuBar 컴포넌트를 JFrame에 붙이기
		setJMenuBar(mb);
	}
	
	public static void main(String [] args) {
		new MenuEx();
	}
}