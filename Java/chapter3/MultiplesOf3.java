// 정수를 10개 입력받아 배열에 저장한 후, 배열을 검색하여 3의 배수만 골라 출력하는 프로그램을 작성하라.
import java.util.Scanner;
import java.util.InputMismatchException;

public class MultiplesOf3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];

        System.out.print("정수 10개 입력>>>");
        for(int i=0;i<10;i++){
            try{
                arr[i] = sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Please enter an Integer!");
                sc.next();
                i--;
            }
        }
        for(int k: arr){
            if(k%3==0) System.out.print(k+" ");
        }
        sc.close();
    }
}
