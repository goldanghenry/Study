public class BookMain {
    public static void main(String[] args){
        Book a = new Book("홍길동전");
        Book b = new Book("어린왕자", "생텍쥐페리");

        System.out.println(a.gettitle()+" "+a.author);
        System.out.println(b.gettitle()+" "+b.author);
    }
}
