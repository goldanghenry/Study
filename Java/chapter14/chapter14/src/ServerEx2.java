import java.io.*;
import java.net.*;

public class ServerEx2 {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9999);
			System.out.println("연결 기다림....");
			socket = listener.accept();
			System.out.println("연결되었음.");
		} catch (IOException e) {}
		try {
			listener.close();
			socket.close();
		} catch(IOException e) {}
	}
}