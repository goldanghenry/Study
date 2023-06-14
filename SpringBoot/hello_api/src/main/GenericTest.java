package main;

import model.Book;
import model.ObjectArr;

public class GenericTest {
    public static void main(String[] args) {
        /*
        ObjectArr<String> array = new ObjectArr<>(5);
        array.set(0,"hello");
        array.set(1,"hello");
        array.set(2,"hello");
        array.set(3,"hello");

        for(int i=0; i<array.size();i++){
            System.out.println(array.get(i));
        }
    }*/
        ObjectArr<Book> bList = new ObjectArr<>(5);
        bList.set(0, new Book("어린왕자"));
        bList.set(1, new Book("나혼자무공"));
        bList.set(2, new Book("만렙뉴비"));
        bList.set(3, new Book("후작가의 역대급 막내아들"));

        for(int i=0;i<bList.size();i++){
            System.out.println(bList.get(i));
        }

    }

}
