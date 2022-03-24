public class Constructor {
    String title;
    String author;

    void Show(){
        System.out.println(title+": "+author);
    }
    public Constructor() {
        this("no title","no author");
        System.out.print("1 ");
    }
    public Constructor(String title){
        this(title, "작자미상");
        System.out.print("2 ");
    }
    public Constructor(String title, String author){
        this.title = title;
        this.author = author;
        System.out.print("3");
    }
    public static void main(String[] args){
        Constructor emptyBook = new Constructor();            // 3 -> 1
        Constructor loveStory = new Constructor("춘향전");    // 3 -> 2
        Constructor littlePrince = new Constructor("어린왕자", "생텍쥐페리"); // 3
        System.out.println(emptyBook.title+emptyBook.author);
        System.out.println(loveStory.title+loveStory.author);
        System.out.println(littlePrince.title+littlePrince.author);
    }
}
