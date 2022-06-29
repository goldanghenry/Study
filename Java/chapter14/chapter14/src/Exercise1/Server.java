// 실습1
// 클라이언트가 정수를 보내면 서버는 받는 수자의 합을 누적하여 출력하는 프로그램
// 음수를 보내면 연결을 끊고 종료
package Exercise1;
import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader in = null;
        int sum = 0;
		try {
			listener = new ServerSocket(9999);
			System.out.println("서버 입니다. 클라이언트를 기다립니다...");
			socket = listener.accept();
			System.out.println("연결 되었습니다.");
			//-------------
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String inputMessage = in.readLine();
				if(Integer.valueOf(inputMessage) < 0) {
					System.out.println("서버를 종료합니다.");
					break;
				}
                sum += Integer.valueOf(inputMessage);
				System.out.println("누적합: " + sum);
			}
		} catch (IOException e) {}
		try {
			listener.close();
			socket.close();
		} catch (Exception e) {}
	}

}
