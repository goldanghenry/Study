package main;

import model.MathOperation;

/* 자바에서 함수형 인터페이스를 사용하는 이유
1. 람다 표현식 지원
2. 메서드 참조
3. Stream API와의 통합
4. 병렬 프로그래밍
5. 코드 재사용
*/

/* 메서드 참조 유형
1. 정적 메서드 참조: 클래스명::메서드명
2. 인스턴스 메서드 참조: 객체참조::메서드명
3. 특정 객체의 인스턴스 메서드 참조: 클래스명::메서드명
4. 생성자 참조: 클래스명::new
*/

public class FunctionInterfaceTest {
    public static void main(String[] args) {
        // 인터페이스는 반드시 구혖체가 있어야 하지만, 익명 내부클래스로 바로 객체를 생성할 수 있다.
        MathOperation mo = new MathOperation() {
            @Override
            public int operation(int x, int y) {
                return x+y;
            }
        };
        int result =mo.operation(10,20);
        System.out.println(result);
    }
}
