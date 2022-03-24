import java.util.Scanner;

public class ArraySort {    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];

        System.out.print("정수 10개 입력:");
        for(int i=0; i<10;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<arr.length;i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int k: arr){
            System.out.print(k+" ");
        }
        sc.close();
    }
}

