// 초 단위의 정수를 입력받고, 몇 시간, 몇 분, 몇 초인지 출력하라
package chapter2;
import java.util.Scanner;

public class Clock {
    public static void main(String[] args){
        int t, h=0,m=0,s=0;
        System.out.print("초를 입력하면 시,분,초로 나타냅니다: ");
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        h = t/3600;
        m = (t/60)%60;
        s = t%60;

        System.out.println(h+"시간 "+m+"분 "+s+"초");
        scanner.close();
    }
}
