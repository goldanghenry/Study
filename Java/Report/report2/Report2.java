import java.util.Scanner;

public class Report2 {
    static Scanner sc = new Scanner(System.in); // static으로 Scanner 객체 선언
    static void method1(){
        // Account1 클래스를 참조하여 account1과 account2의 deposit를 입력받아 각각의
        // balance를 디스플레이하는 메소드를 작성하시오.
        Account1 account1 = new Account1("홍길동");
        Account1 account2 = new Account1("동홍길");

        System.out.print("Enter deposit amount for account1: ");
        account1.credit(sc.nextDouble());
        System.out.print("Enter deposit amount for account2: ");
        account2.credit(sc.nextDouble());

        System.out.print("account1 balance: $"+account1.getBalance()+"\n");
        System.out.print("account2 balance: $"+account2.getBalance()+"\n\n");
    }
    static void method2(){
        // 아래 코드를 참조하여 홍길동 예금주의 잔액과 이자률을 계산한 잔액을 디스플레이하는 메소드 구현
        Account1 account = new Account1("홍길동");
        account.credit(1000.0);
        account.print();

        account.addInterest(1.1);
        account.print();
        System.out.print("\n\n");
    }

    static void method3(){
        // 두 개의 정수를 입력받아 이 숫자들의 덧셈, 뺄셈, 곱셈, 나눗셈 한 결과를 출력하는 메소드를 작성하시오.
        int n, m;
        System.out.print("Enter first integer : ");
        n = sc.nextInt();
        System.out.print("Enter second integer : ");
        m = sc.nextInt();

        // 결과 출력
        System.out.println("Sum is "+(n+m));
        System.out.println("Product is "+(n*m));
        System.out.println("Difference is "+(n-m));
        System.out.println("Quotient is "+(n/m));
    }
    
    public static void main(String[] args){
        method1();
        method2();
        method3();
    }
}
