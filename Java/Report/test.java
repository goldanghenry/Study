// 제네릭 클래스

public class test <T> {
    T val;
    void set(T a){ this.val = a;}
    T get() {return val;}

    public static void main(String[] args){
        test<Integer> s = new test<Integer>();
        s.set(5);

    }
}