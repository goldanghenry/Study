// 영문 소문자를 하나 입력받고 그 문자보다 알파벳 순위가 낮은 모든 문자를 출력하는 프로그램을 작성하라.
import java.util.Scanner;


public class StringToChar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("알파벳 한 문자를 입력하세요>>");
        String L = sc.next();
        char c = L.charAt(0);
        
        for(char a='a';a<=c;a++){
            for(char b=a;b<=c;b++){
                System.out.print(b);
            }
            System.out.println();
        }
        sc.close();
    }
}
