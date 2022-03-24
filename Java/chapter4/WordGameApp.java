// n명이 참가하는 끝말잇기 게임
import java.util.Scanner;

class Player{
    static Scanner sc = new Scanner(System.in);
    String name;
    String word;

    Player(){
        System.out.print("참가자의 이름을 입력하세요>>");
        this.name = sc.next();
    }
}

public class WordGameApp {
    static Scanner sc = new Scanner(System.in);
    int num;
    String subject;
    
    WordGameApp(){
        System.out.print("게임에 참가하는 인원은 몇명입니까>>");
        num = sc.nextInt();
        this.subject = "아버지";
    }

    int run(Player a){
        int lastIndex = (this.subject.length()-1);
        char lastChar = this.subject.charAt(lastIndex);

        System.out.print(a.name+">>");
        a.word = sc.next();
        char firstChar = a.word.charAt(0);
        if(lastChar == firstChar) {
            this.subject = a.word;
            return 1;
        } else {
            System.out.println(a.name+"이 졌습니다.");
            return -1;
        }
    }

    public static void main(String[] args){
        WordGameApp game1 = new WordGameApp();
        
        Player a[] = new Player[game1.num];
        for(int i=0; i<a.length;i++){
            a[i] = new Player();
        }
        System.out.println("시작하는 단어는 "+game1.subject+"입니다");
        int i = 0, check = 1;
        while(check == 1){
            check = game1.run(a[i]);
            if(i==game1.num-1) i-=game1.num-1;
            else i++;
        }
        
    }
}
