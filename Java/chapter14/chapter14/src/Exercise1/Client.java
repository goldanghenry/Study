package Exercise1;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedWriter out = null;
		Scanner scanner = new Scanner(System.in);
		int input;
		try {
			socket = new Socket("localhost", 9999);
			System.out.println("서버에 접속하였습니다...");
			// ----------------------
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				System.out.print("보낼 정수 입력 >> ");
				try {
					input = scanner.nextInt();
					String outputMessage = Integer.toString(input);
					if (input < 0) {
						out.write(outputMessage + "\n");
						out.flush();
						System.out.println("연결을 종료합니다.");
						break;
					}
					out.write(outputMessage + "\n");
					out.flush();
				} catch (InputMismatchException e) {
					System.out.println("정수를 입력하세요");
					scanner.next();
				}
			}
		} catch (IOException e) {
		}
		try {
			socket.close();
			scanner.close();
		} catch (Exception e) {
		}
	}

}