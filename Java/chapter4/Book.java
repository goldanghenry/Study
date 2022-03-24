public class Book {
    private String name;
    String author;

    Book(String name){
        this.name = name; this.author ="작가미상";
    }
    Book(String name, String author){
        this. name = name; this.author = author;
    }
    public String gettitle(){
        return name;
    }

    public static void main(String[] args){
        Book a = new Book("홍길동전");
        Book b = new Book("어린왕자", "생텍쥐페리");

        System.out.println(a.name+" "+a.author);
        System.out.println(b.name+" "+b.author);
    }
}
