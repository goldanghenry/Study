import java.util.Scanner;

public class dictionary {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String eng[] = {"student", "love", "java", "happy", "future"};
        String kor[] = {"학생", "사랑", "자바", "행복", "미래"};
        String word;

        while(true){
            System.out.print("영어 단어를 입력하세요>>");
            word = sc.next();
            int index = -1;
            if(word.equals("exit")) {
                System.out.println("종료합니다...");
                sc.close();
                System.exit(1);
            }
            for (int i=0; i<eng.length; i++){
                if(word.equals(eng[i])) {
                    index = i;
                    break;
                }
            }
            if(index==-1) System.out.println("그런 영어 단어가 없습니다.");
            else System.out.println(kor[index]);
        }
    }
}
