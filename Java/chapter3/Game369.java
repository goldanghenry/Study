package chapter3;

public class Game369 {
    public static void main(String[] args){
        int first, second, clap;

        for(int i=1;i<100;i++){
            first = i/10;
            second = i%10;
            clap = 0;

            if(first!=0 && (first%3==0 || first%6==0 || first%9==0)) clap++;
            if(second!=0 && (second%3==0 || second%6==0 || second%9==0)) clap++;

            if(clap==1) System.out.println(i+" 박수한번");
            else if(clap==2) System.out.println(i+" 박수두번");
        }
    }
}
