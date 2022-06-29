import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatServer extends JFrame implements ActionListener {	// Enter -> ActionEvent
	private BufferedReader in = null;	// 입력용 버퍼
	private BufferedWriter out = null;	// 출력용 버퍼
	private ServerSocket listener = null; // server용 socket
	private Socket socket = null;		// client용 socket
	private Receiver receiver;  // 출력창
	private JTextField sender; 	// 입력창

	
	public ChatServer() {
		setTitle("Chat_System"); // GUI 상단바
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x로 GUI 종료
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout()); //BorderLayout으로 화면 배치
		receiver = new Receiver(); // 리시버 생성
		receiver.setEditable(false); // 받는 화면, 편집 불가 setting

		sender = new JTextField();	// 한 줄의 입력창
		sender.addActionListener(this); // 리스너 붙이기

		add(new JScrollPane(receiver),BorderLayout.CENTER); // ��ũ�ѹٸ� ����  ScrollPane �̿�
		add(sender,BorderLayout.SOUTH);
		
		setSize(400, 200); // �� 400 �ȼ�, ���� 200 �ȼ��� ũ��� ������ ũ�� ����
		setVisible(true); // �������� ȭ�鿡 ��Ÿ������ ����
		
		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		
		Thread th = new Thread(receiver); // 
		th.start();
	}
	private void setupConnection() throws IOException {
		listener = new ServerSocket(9999); // ���� ���� ����
		socket = listener.accept(); // Ŭ���̾�Ʈ�κ��� ���� ��û ���
		//System.out.println("�����");
		receiver.append("Ŭ���̾�Ʈ�κ��� ���� �Ϸ�");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos); // caret �������� ���� ���������� �̵�
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Ŭ���̾�Ʈ�κ����� �Է� ��Ʈ��
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Ŭ���̾�Ʈ���� ��� ��Ʈ��
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String msg = null;
			while (true) {
				try {
					msg = in.readLine(); // ���κ��� �� ���� ���ڿ� �ޱ�
				} catch (IOException e) {
					handleError(e.getMessage());
				} 
				this.append("\n  Ŭ���̾�Ʈ : " + msg); // ���� ���ڿ��� JTextArea�� ���
				int pos = this.getText().length();
				this.setCaretPosition(pos); // caret �������� ���� ���������� �̵�
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // JTextField�� <Enter> Ű ó��
		if (e.getSource() == sender) {
			String msg = sender.getText(); // �ؽ�Ʈ �ʵ忡�� ���ڿ� ����
			try {
				out.write(msg+"\n"); // ���ڿ� ����
				out.flush();
				
				receiver.append("\n���� : " + msg);// JTextArea�� ���
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos); // caret �������� ���� ���������� �̵�
				sender.setText(null); // �Է�â�� ���ڿ� ����
			} catch (IOException e1) {
				handleError(e1.getMessage());
			} 
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
