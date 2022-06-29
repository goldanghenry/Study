import java.io.*;

public class BinaryCopy {
	public static void main(String[] args) {
		File src = new File("C:/Users/wshkk/Desktop/Programming/java/chapter13/꽃.jpg"); // 원본 파일 경로
		File dest = new File("C:/Users/wshkk/Desktop/Programming/java/chapter13/꽃c.jpg"); // 복사 파일 경로

		int c;
		try {
			FileInputStream fi = new FileInputStream(src); 
			FileOutputStream fo = new FileOutputStream(dest); 
			while((c = fi.read()) != -1) { // 하나씩 복사 -> 시간 많이 걸림
				fo.write((byte)c);
			}
            fi.close();
            fo.close();
            System.out.println(src.getPath()+ "를 " + dest.getPath()+ "로 복사하였습니다.");
		} catch (IOException e) {
			System.out.println("파일 복사 오류");
		}
	}
}