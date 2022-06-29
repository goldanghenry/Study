import java.io.*;
import java.net.*;
import java.util.*;

public class ClientEx {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedWriter out = null;
		Scanner scanner = new Scanner(System.in);
		BufferedReader in = null;
		try {
			socket = new Socket("localhost", 9999);
			//----------------------
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				System.out.print("보내기>>");
				String outputMessage = scanner.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n");
					out.flush();
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				out.write(outputMessage+"\n");
				out.flush();
				//---------------------------
				String inputMessage = in.readLine();
				System.out.println("서버: " + inputMessage);
			}
		} catch (IOException e) {}
		try {
			socket.close();
			scanner.close();
		} catch (Exception e) {}
	}

}
