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