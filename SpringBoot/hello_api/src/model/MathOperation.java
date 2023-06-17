package model;

/*함수형 인터페이스
하나의 추상 메서드만 있어야 한다.*/
@FunctionalInterface
public interface MathOperation {
    public int operation(int x, int y); // 추상메서드
}
