abstract class CC {
    abstract void f();
}
public class D extends CC {
    @Override
    public void f(){
        System.out.println("객체 생성");
    }

    public static void main(String[] args){
        D d = new D();
        d.f();  // 화면에 객체 생성을 출력
    }
}
