// 라인 번호를 붙여 텍스트 파일을 화면에 출력하는 프로그램을 작성하라.
// c:/windows/system.ini
import java.io.*; // FIleReader
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 키보드로부터 읽기 위한 목적
        String src;
        System.out.print("텍스트 파일 이름을 입력하세요>>");
        src = scanner.nextLine();   // 키보드로부터 한줄의 파일명을 읽는다.
        try {
            Scanner sc = new Scanner(new FileReader(src));
            String line;
            int lineNumber = 1;
            while(scanner.hasNext()){
                line = sc.nextLine();
                System.out.printf("%4d", lineNumber++);   // 숫자는 뒤에부터 붙어서 포맷.
                System.out.println(": "+line);
            }
            sc.close();
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.print(" 파일을 찾을 수 없습니다 ");
        } catch(NoSuchElementException e) {
            System.out.println("파일의 끝에 도달하여 읽을 내용이 없습니다.");
        }
        
        
    }
}
