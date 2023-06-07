package main;

import model.HideClass;
import model.ObserverInterface;

// 옵저버 역할을 하는 인터페이스를 이용해 숨겨진 클래스를 동작
public class ObserverExam {
    public static void main(String[] args) {
        ObserverInterface observerInterface = new HideClass();
        observerInterface.x();  // 동적 바인딩, 다형성
        observerInterface.y();
        observerInterface.z();
    }
}
