import java.util.Scanner;
public class arithmeticOperator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double a, b;
        String o;

        
        System.out.print("식을 입력하세요>>");
        a = sc.nextDouble();
        o = sc.next();
        b = sc.nextDouble();
        sc.close();

        switch(o){
            case "+": System.out.println("연산 결과 "+(a+b)); break;
            case "-": System.out.println("연산 결과 "+(a-b)); break;
            case "*": System.out.println("연산 결과 "+(a*b)); break;
            case "/": 
            if(b==0) {System.out.println("0으로 나눌 수 없습니다."); System.exit(1);}
            else System.out.println("연산 결과 "+(a/b));
        }
    }
}
