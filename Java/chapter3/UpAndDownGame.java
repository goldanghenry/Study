// 숨은 버호를 맞추는 게임
// 컴퓨터는 0~99까지의 임의의 수를 선택하고, 사용자는 이 수를 맞추는 게임
// '더 높게' or '더 낮게' 출력, 맞으면 y/n으로 재시작을 선택한다.
package chapter3;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class UpAndDownGame {
    public static void main(String[] args){
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int k = r.nextInt(100);  // 0~99까지 임의의 정수 생성
        int user = -1, count = 1, L=0, R=99;
        String m;

        System.out.println("Up & Down게임입니다. 숨겨진 수를 맞추어 보세요.");
        while(true){
            System.out.println(L+"-"+R);
            System.out.print(count+">>");
            try{
                user = sc.nextInt();
            } 
            catch(InputMismatchException e) {
                System.out.println("Please enter an Integer!");
                sc.nextLine();
                continue;
            }
            count++;
            if(user > k) {
                System.out.println("더 낮게");
                L=user;
            } else if ( user < k) {
                System.out.println("더 높게");
                R=user;
            } else {
                System.out.print("맞았습니다.\n다시 하시겠습니까(y/n)>>");
                m=sc.next();
                if (m.equals("y")) {
                    user = -1; L = 0; R = 99; count = 0;
                    k = r.nextInt(100);
                    System.out.println("Up & Down게임입니다. 숨겨진 수를 맞추어 보세요.");
                } else if(m.equals("n")) {
                    sc.close();
                    System.exit(1);
                }
            }
        }
    }
}
