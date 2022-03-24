import java.util.Scanner;

public class Phone {
    private String name, tel;
    public Phone(String name, String tel){
        this.name = name;
        this.tel =tel;
    }
    public String getName(){
        return this.name;
    }public String getTel(){
        return this.tel;
    }
}

class PhoneManager {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Phone a[] = new Phone[2];
        String temp1, temp2;
        for(int i=0;i<a.length;i++){
            System.out.print("이름과 전화번호 입력 >>");
            temp1 = sc.next(); temp2 = sc.next();
            a[i] = new Phone(temp1,temp2);
        }

        System.out.println(a[0].getName() + "의 번호 " + a[0].getTel());
        System.out.println(a[1].getName() + "의 번호 " + a[1].getTel());
        sc.close();
    }
}