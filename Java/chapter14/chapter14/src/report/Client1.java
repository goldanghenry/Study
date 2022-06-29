package report;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client1 {
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
				// 서버로 보내기
				System.out.print("두 정수를 빈칸으로 띄어 입력, 예)24 42>>");
				String outputMessage = scanner.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n");
					out.flush();
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				out.write(outputMessage+"\n");
				out.flush();

				// 서버에서 계산 결과 받아오기
				String inputMessage = in.readLine();
				if(inputMessage.equals("양식에 맞게 입력하세요")){
					System.out.println(inputMessage);
				}
				else{
					System.out.println("계산 결과 : "+inputMessage);
				}
			}
		} catch (IOException e) {}
		try {
			socket.close();
			scanner.close();
		} catch (Exception e) {}
	}

}
