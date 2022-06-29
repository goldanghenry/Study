import java.io.*;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		byte b[] = {7,51,3,4,-1,24};
		
		try {
			FileOutputStream fout = new FileOutputStream("C:/Users/wshkk/Desktop/Programming/java/chapter13/test.out");
			/*
			for(int i=0;  i<b.length; i++)
				fout.write(b[i]); // 배열 b의 바이너리를 그대로 기록
			*/
			fout.write(b);
				fout.close();
		} catch(IOException e) { }
		System.out.println("C:/Users/wshkk/Desktop/Programming/java/chapter13/test.txt을 저장");
	}
}