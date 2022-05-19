// 실습 1번
// Scaaner를 사용하여 학점 (A,B,C,D,F), 5개만 입력받아 ArrayList에 저장하라.
// 그리고 나서 다시 ArrayList를 검색하여 5개의 학점을 점수로 변환하여 출력하는 프로그램을 작성하라.
// A=4.0, B=3.0, C=2.0, D=1.0, F=0.0
import java.util.*;
public class practice1 {
    public static void main(String[] args){
        ArrayList <String> list = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        

        for(int i=0; i<list.size();i++){
            System.out.print("학점을 입력하세요>>");
            String n = sc.next();
            list.add(n);
        }
        for(int i=0; i<list.size();i++){
            switch(list.get(i)){
                case "A": System.out.print("A:4.0 "); break;
                case "B": System.out.print("B:3.0 "); break;
                case "C": System.out.print("C:2.0 "); break;
                case "D": System.out.print("D:1.0 "); break;
                case "F": System.out.print("F:0.0 "); break;
                default: System.out.print("잘못 입력하였습니다.");
            }
        }
        sc.close();
    }
}
