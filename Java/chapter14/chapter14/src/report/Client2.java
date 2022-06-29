package report;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client2 {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedWriter out = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("localhost", 9999);
            System.out.println("서버에 접속하였습니다...");
			//----------------------
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				// 서버로 보내기
				System.out.print("텍스트 입력 >> ");
				String outputMessage = scanner.nextLine();
				if(outputMessage.equalsIgnoreCase("끝")) {
					out.write(outputMessage+"\n");
					out.flush();
					System.out.println("연결을 종료합니다.");
					break;
				}
				out.write(outputMessage+"\n");
				out.flush();
			}
		} catch (IOException e) {}
		try {
			socket.close();
			scanner.close();
		} catch (Exception e) {}
	}

}
