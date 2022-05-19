// 실습 2, 시험!
// 도서정보(책이름, 출판사, 년도)를 입력받아 ArrayList<Library>에 저장한다.
// Hint: class Library(name, publisher, year)를 만듦. 생성자, geter, toString() {프린트(name+publisher+year)}도 같이 작성
import java.util.*;
class Library {
    private String name;
    private String publisher;
    private int year;
    Library(String name, String publisher, int year){
        this.name = name; this.publisher = publisher; this.year = year;
    }
    public String toString(){
        return "[name="+this.name+", publisher="+this.publisher+", year="+this.year+"]";
    }
    public String getName(){
        return this.name;
}

public class practice2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Library> bookList = new ArrayList<Library>();
        String name;
        String publisher;
        int year;
        Boolean check;
        System.out.println("--------------- 도서관리시스템 ---------------");
        while(true){
            System.out.println("삽입:1, 삭제:2, 찾기:3, 전체보기:4, 종료:5  --> ");
            switch(sc.nextInt()){
                case 1: // 삽입
                System.out.print("책이름 -->> "); name = sc.next();
                System.out.print("출판사 -->> "); publisher = sc.next();
                System.out.print("년도   -->> "); year = sc.nextInt();
                bookList.add(new Library(name, publisher, year)); break;

                case 2: // 삭제
                System.out.print("삭제하려는 책의 이름을 입력하세요 --> "); name = sc.next();
                check = false;// 초기화
                for(int i=0; i<bookList.size();i++){
                    if(name.equals(bookList.get(i).getName())){
                        check = true;
                        bookList.remove(i);
                    }
                }
                if(check == false) System.out.println("삭제하려는 책이 없습니다"); break;
                case 3: // 찾기
                System.out.print("찾고자하는 책의 이름을 입력하세요 --> "); name = sc.next();
                check = false;// 초기화
                for(int i=0; i<bookList.size();i++){
                    if(name.equals(bookList.get(i).getName())){
                        check = true;
                        System.out.println("찾고자 하는 책 "+name+"의 위치는 "+i+"번째에 있습니다");
                    }
                }
                if(check == false) System.out.println("찾는 책이 없습니다"); break;
                case 4: 
                for(int i=0; i<bookList.size(); i++){
                    Library B = bookList.get(i);
                    System.out.println(B);
                } break;
                case 5: 
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(1); break;
                default: System.out.println("잘못 입력하셨습니다."); 
            }
            sc.close();
        }
        
    }
}
}
