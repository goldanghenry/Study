import java.io.*;
import java.net.*;
import java.util.*;

public class ClientEx3 {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedWriter out = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("localhost", 9999);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				System.out.print("보내기>>");
				String outputMessage = scanner.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n");
					out.flush();
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
