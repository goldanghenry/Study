package report1;
import java.util.Scanner;

public class Report1 {
    static Scanner scanner = new Scanner(System.in);
    static void method1(){
        int grade, count=0, sum=0;
        double avg = 0.0;

        while(true){
            System.out.print("Enter grade: ");
            grade = scanner.nextInt();
            if (grade == -1) break;
            sum += grade;
            count++;
        }
        if (count == 0){
            System.out.println("1개 이상 점수를 입력하세요.");
            System.exit(1);
        }
        avg = sum/count;
        System.out.println("\nTotal of "+count+" student grades is "+sum);
        System.out.println("Class average is "+(int)avg+"\n");
    }

    static void method2(){
        int grade, A=0,B=0,C=0,D=0,F=0;
        while(true){
            System.out.print("Enter grade: ");
            grade = scanner.nextInt();
            if(grade == -1) break;

            switch(grade/10){
                case 10: case 9: A++; break;
                case 8: B++; break;
                case 7: C++; break;
                case 6: D++; break;
                default: F++;
            }
        }
        System.out.println("\nNumber of students who received each grade:");
        System.out.println("A: "+A);
        System.out.println("B: "+B);
        System.out.println("C: "+C);
        System.out.println("D: "+D);
        System.out.println("F: "+F+"\n");
    }

    static void method3(){
        int arr_money[]={50000,10000,1000,500,100,50,10,1};
        int pay_money[]={0,0,0,0,0,0,0,0};
        String name_money[] ={"오만원권","만원권", "천원권", "오백원", "백원","오십원","십원","일원"};
        
        System.out.print("금액을 입력하시오 : ");
        int money = scanner.nextInt();
        scanner.close();

        for (int i=0; i<arr_money.length; i++){
            pay_money[i] = money/arr_money[i];
            if(pay_money[i]!=0 && i<=2){
                System.out.println(name_money[i]+" "+pay_money[i]+"매");
            } else if(pay_money[i]!=0 && i>3) {
                System.out.println(name_money[i]+" "+pay_money[i]+"개");
            }
            money %= arr_money[i];
        }
    }
    public static void main(String[] args){ 
        method1();
        method2();
        method3();
    }
}
