package chapter2;
import java.util.Scanner;


public class Logic_Calculater {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean a,b;
        String o;

        System.out.print("논리 연산을 입력하세요>>");
        a = scanner.nextBoolean();
        o = scanner.next();
        b = scanner.nextBoolean();
        scanner.close();

        switch(o){
            case "OR":
            System.out.println(a||b);
            break;
            case "AND":
            System.out.println(a&&b);
            break;
        }
    }
}
