import java.io.*;

public class FileInputStreamEx {
	public static void main(String[] args) {
		byte b[] = new byte [6]; // 비어 있는 byte 배열
		try {
			// "c:\\Temp\\test.out" ������ �о� �迭 b�� ����
			FileInputStream fin = new FileInputStream("C:/Users/wshkk/Desktop/Programming/java/chapter13/test.out");
			int n=0, c; // c는 int
			while((c = fin.read())!= -1) {
				b[n] = (byte)c; // c는 읽은 바이트 개수, 읽은 바이트를 배열에 저장
				n++;
			}
			
			System.out.println("C:/Users/wshkk/Desktop/Programming/java/chapter13/test.out에서 읽은 배열을 출력");
			for(int i=0; i<b.length; i++) // �迭 b ���
				System.out.print(b[i]+" ");
			System.out.println();
			
			fin.close();
		} catch(IOException e) { }
	}
}