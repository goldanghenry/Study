abstract class A {  // 추상 클래스 선언
    abstract public int add(int x, int y); // 추상 메소드
}

abstract class B extends A { // 추상 클래스, 추상 메소드 add()를 상속받기 때문
    public void show() { System.out.println("B"); }
}

class C extends A { // 추상 클래스 구현, C는 정상 클래스
    @Override
    public int add(int x, int y) { return x+y;} // 추상 메소드 구현. 오버라이딩
    public void show() { System.out.println("C");}
}

public class abstractEx {
    //A a = new A();  // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
    //B b = new B();  // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가

    C c = new C();  // 정상

}
