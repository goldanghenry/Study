package main;
import java.util.Scanner;

public class StringSplit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = "Hello,world,Java";
        String[] strArr = str.split(",");
        for (String s:strArr){
            System.out.println(s);
        }

        System.out.println("문자열을 입력하세요:");
        String str1 = sc.nextLine();
        String[] strArr1 = str1.split("\\s+");  // 정규식, \s는 하나 이상의 공백

        for (String s : strArr1){
            System.out.println(s);
        }

        sc.close();
    }
}
