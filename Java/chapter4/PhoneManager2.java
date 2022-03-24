import java.util.Scanner;
public class PhoneManager2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,t;

        // 입력 받기
        System.out.print("인원수>>");
        n = sc.nextInt();
        String target;
        Phone a[] = new Phone[n];

        String temp1, temp2;
        for(int i=0;i<a.length;i++){
            System.out.print("이름과 전화번호(번호는 연속적으로 입력)>>");
            temp1 = sc.next(); temp2 = sc.next();
            a[i] = new Phone(temp1,temp2);
        }
        System.out.println("저장되었습니다....");

        while(true){
            t=0;
            System.out.print("검색할 이름>>");
            target = sc.next();
            if(target.equals("exit")) break;
            for(int i=0; i<a.length;i++){
                if(a[i].getName().equals(target))
                    System.out.println(target+"의 번호는 "+a[i].getTel()+"입니다.");
                    t=1;
            }
            if(t==0) System.out.println(target+"가 없습니다.");
        }
        System.out.println("프로그램을 종료합니다...");
        sc.close();
    }    
}
