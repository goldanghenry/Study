// 실습1. First 부분을 thread로 만들어 2개의 스레드가 실행하도록 고침
public class Exercise1 {
    public static void main(String[] args){
        // First: "A"부터 "z"까지 100번 print
        Thread th = new Count();    //Thread 대신에 Count 써도 됨.
        th.start();
        // Second: 1부터 1000까지 10개씩 print
        for(int i=1; i<1001;i++){
            System.out.print(i);
            if(i%10==0) System.out.println();
            else System.out.print("\t");
        }
    }   
}

class Count extends Thread {
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            for(char ch='A';ch<='z';ch++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}