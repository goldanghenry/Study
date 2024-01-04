package org.example;
// 중첩 클래스로 싱글톤 패턴 구현
class Singleton {
    // static으로 SingleInstanceHolder 클래스 생성
    private static class SingleInstanceHolder {
        // Static final로 인스턴스 생성
        private static final Singleton INSTANCE = new Singleton();
    }
    // 하나의 인스턴스만 리턴하는 메서드
    public static Singleton getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }
}
/*
public class Singleton {
    // private 정적 변수로 자신의 유일한 인스턴스를 가지고 있음
    private static Singleton instance;

    // private 생성자로 외부에서 객체 생성을 막음
    private Singleton() {
        // 초기화 코드
    }

    // 공개 정적 메서드를 통해 외부에서 인스턴스에 접근
    public static Singleton getInstance() {
        if (instance == null) {
            // 인스턴스가 없으면 생성
            instance = new Singleton();
        }
        return instance;
    }

    // 다른 메서드 및 속성들을 추가할 수 있음
}
*/