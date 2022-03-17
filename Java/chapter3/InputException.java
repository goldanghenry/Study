// 3개의 정수를 입력받아 합을 구하는 프로그램
package chapter3;
import java.util.Scanner;
import java.util.InputMismatchException;

public class InputException {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum=0, n=0;
        for(int i=0; i<3; i++) {
            try{
                n = sc.nextInt();
            } 
            catch (InputMismatchException e) {
                System.out.println("Please enter an Integer");
                sc.next();   // 입력 스트림에 있는 정수가 아닌 토큰을 버린다.
                i--;    // 인덱스가 증가하지 않도록 미리 감소
                continue;   // 다음 루프
            }
            sum += n;
        }
        System.out.println("합은: "+sum);
        sc.close();
    }
}