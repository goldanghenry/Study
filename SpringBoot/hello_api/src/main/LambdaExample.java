package main;

import model.MathOperation;

public class LambdaExample {
    public static void main(String[] args) {
        // java.util.function 패키지에는 많은 함수형 인터페이스가 정의되어 있어 람다 함수를 통해 구현해 사용할 수 있다.
        // (parameters) -> {expression}
        MathOperation add = (int x, int y) -> {return x+y;};
        // 추상 메서드를 구현하는 것이기 때문에 parameter의 타입과 return 문구를 생략할 수 있다.
        // MathOperation add = (x, y) -> x+y;   // 한 줄의 경우 중괄호도 생략가능

        int result = add.operation(10,20);
        System.out.println("10+20="+result);

    }
}
