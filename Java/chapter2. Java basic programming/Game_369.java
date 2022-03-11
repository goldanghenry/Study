package chapter2;
import java.util.Scanner;

public class Game_369 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num, first, second, c=0;

        System.out.print("1~99사이의 정수를 입력하세요>>");
        num = sc.nextInt();
        sc.close();

        first = num/10;
        second = num%10;

        if (first%3==0 || first%6==0 || first%9==0) c++;
        if (second%3==0 || second%6==0 || second%9==0) c++;

        switch(c){
            case 2: System.out.println("박수짝짝"); break;
            case 1: System.out.println("박수짝"); break;
            default: System.out.println("박수없음");
        }
        
    }
}
