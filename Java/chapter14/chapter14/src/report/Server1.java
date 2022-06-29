/* Report 11 - 1
	서버 프로그램은 클라이언트 프로그램으로부터 수신된 두 개의 정수를 더해서 합을 구한 후 
	그 결과를 되돌려 송신하는 프로그램을 작성하라. 반드시 숫자 사이에는 빈칸을 삽입하여 
	전송하도록 하고, bye를 입력하면 프로그램을 끝낸다.
*/
package report;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server1 {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			listener = new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다.....");
			socket = listener.accept();
			System.out.println("연결 되었습니다.");
			//-------------
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				// 클라이언트에게 받기
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 연결을 종료하였음");
					break;
				}
				// 토큰으로 나눠서 클라이언트에게 계산결과 보내기
				StringTokenizer st = new StringTokenizer(inputMessage, " ");
				if(st.countTokens()!=2) {
					out.write("양식에 맞게 입력하세요"+"\n");
					out.flush();
				}
				else  {
					int op1 = Integer.parseInt(st.nextToken());
					int op2 = Integer.parseInt(st.nextToken());
					out.write(Integer.toString(op1+op2)+ "\n");
					out.flush();
				}
			}
		} catch (IOException e) {}
		try {
			listener.close();
			socket.close();
		} catch (Exception e) {}
	}

}
