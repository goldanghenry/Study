/* Report 11 - 2
	클라이언트에서는 한 줄씩 텍스트를 입력 받아 서버로 보내고, 서버는 받은 텍스트를 출력하는 소켓 프로그램을 작성하라. 
    클라이언트가 끝을 입력하고 엔터를 치면 프로그램은 종료한다
*/
package report;
import java.io.*;
import java.net.*;

public class Server2 {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader in = null;
		try {
			listener = new ServerSocket(9999);
			System.out.println("서버입니다. 클라이언트를 기다립니다...");
			socket = listener.accept();
			System.out.println("연결되었습니다.");
			//-------------
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				// 클라이언트에게 받기
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("끝")) {
					System.out.println("서버를 종료합니다.");
					break;
				}
				System.out.println("... "+inputMessage);
			}
		} catch (IOException e) {}
		try {
			listener.close();
			socket.close();
		} catch (Exception e) {}
	}

}
