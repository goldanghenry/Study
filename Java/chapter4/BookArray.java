import java.util.Scanner;

class Book {
    String title;
    String author;

    public Book(String t, String a){    // 생성자
        this.title = t;
        this.author = a;
    }
    public void Show(){
        System.out.println("("+title+", "+author+")");
    }
}

public class BookArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Book BA [] = new Book[2];

        for(int i=0; i<BA.length; i++){
            System.out.print("title>>");
            String t = sc.nextLine();
            System.out.print("author>>");
            String a = sc.nextLine();
            BA[i] = new Book(t,a);
        }
        for(int i=0; i<BA.length; i++){
            BA[i].Show();
        }
        sc.close();
    }
}
