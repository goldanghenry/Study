package chapter2;
import java.util.Scanner;
// 실습1
public class coffeeDiscount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String coffee;
        int count;
        
        System.out.print("커피를 주문하세요>>");
        coffee = sc.next();
        count = sc.nextInt();
        sc.close();
        
        switch(coffee){
            case "에스프레소": 
                if(count >= 10) {
                    System.out.println((int)((2000*count)*0.95)+"원입니다."); break;
                } else {
                    System.out.println(2000*count+"원입니다."); break;}
            case "아메리카노": System.out.println(2500*count+"원입니다."); break;
            case "카푸치노": System.out.println(3000*count+"원입니다."); break;
            case "카페라떼": System.out.println(3500*count+"원입니다.");
        }
    }
}
