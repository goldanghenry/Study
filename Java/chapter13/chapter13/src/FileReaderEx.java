import java.io.*;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader in = null;
		try {
			in = new FileReader("c:\\windows\\system.ini"); // 스트림 생성, 시스템에 원래 있는 파일임
	        int c;
            while ((c = in.read()) != -1) { // 문자를 c에 2byte로 읽어 4byte로 반환, 파일 끝까지.
				// 4byte의 -1과 2byte의 -1은 다르다. 파일 끝을 만나면 -1 리턴
                System.out.print((char)c);
            }
			in.close();
		}
		catch (IOException e) {	// FileNotFoundException e 포함
			System.out.println("입출력 오류");
		}
	}
}