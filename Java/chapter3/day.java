// 실습 2
import java.util.Scanner;
import java.util.InputMismatchException;

public class day {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String day [] = {"일","월","화", "수", "목", "금", "토" };
        int user;

        while(true){
            System.out.print("정수를 입력하세요>>");
            try{
                user =sc.nextInt();
                if(user == -1) {
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    break;
                }
                System.out.println(day[user%7]);
            }
            catch (InputMismatchException e){
                System.out.println("정수를 입력하지 않았습니다");
                sc.next();
            }
        }
    }
}
