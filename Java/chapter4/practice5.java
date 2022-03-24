// 두 사람이 번갈아 하는 갬블링 게임을 만들어 보자.  0에서 2사이 정수 3개를 랜덤하게 발생시켜 모두 같으면 승리한다.
// 선수는 Player 클래스로 표현한다.
import java.util.Scanner;

class Player {  // 선수를 표현하는 클래스
    private String name;    // 선수 이름, private 선언

    Player(String n) { 
        this.name = n; 
    }
    public String getName(){ 
        return this.name; 
    }
}

public class practice5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("check");
        
        Player p[] = new Player[2];

        for(int i=0; i<p.length;i++){
            System.out.print("선수 이름 입력 >>");
            p[i] = new Player(sc.next());
        }
        
        int n=0;
        while(true){
            System.out.print(p[n].getName() + " <Enter 외 아무키나 입력하세요>");
            sc.next();   // y 키를 읽고 버림
            int [] val = new int [3];   // 랜덤 정수를 저장할 정수 배열 생성
            for(int i=0; i<val.length;i++){ // 3개의 랜덤 정수 생성
                val[i] = (int)(Math.random()*3); // 0~2 사이의 랜덤수 발생
                System.out.print(val[i] + "\t");
            }
            System.out.println();   // 한 줄 띄기
            if (val[0] == val[1] && val[0] == val[2]){  // 정수가 모두 같으면
                System.out.println(p[n].getName()+"씨가 승리하였습니다.");
                break;
            }
            n++;
            n = n%2;
        }
        
        sc.close();
    }
}
