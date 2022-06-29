import java.io.*;

public class FileWriterEx {
	public static void main(String[] args) {
		// inputStreamReader로 감싸면 바이트 코드가 문자 코드가 된다.
		InputStreamReader in = new InputStreamReader(System.in); 
		
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("C:/Users/wshkk/Desktop/Programming/java/chapter13/test.txt");
			while ((c = in.read()) != -1) { // ctrl-z가 입력될 때까지 반복
				fout.write(c); // 키보드로부터 받은 문자 하나씩 파일에 저장.
			}
            in.close();
            fout.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}