// 문제2, 이름과 전화번호를 입력받아 2개의 Phone 객체를 생성하고, 출력하는 main()메소드를 작성하라
import java.util.Scanner;

public class practice2 {
    private String name, tel;
    public practice2(String name, String tel){
        this.name = name;
        this.tel = tel;
    }
    public String getName(){ return this.name; }
    public String getTel(){ return this.tel; }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String temp1, temp2;
        System.out.print("이름과 전화번호를 입력 >>");
        temp1 = sc.next();  temp2 = sc.next();
        practice2 a = new practice2(temp1, temp2);
        System.out.print("이름과 전화번호를 입력 >>");
        temp1 = sc.next();  temp2 = sc.next();
        practice2 b = new practice2(temp1, temp2);

        System.out.println(a.getName()+"의 번호 "+a.getTel());
        System.out.println(b.getName()+"의 번호 "+b.getTel());
        sc.close();
    }


}
