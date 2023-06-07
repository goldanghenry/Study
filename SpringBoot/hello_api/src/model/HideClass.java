package model;

// 숨겨진 클래스 -> 노출 시키지 않음 (HideClass.class 파일만 제공), .java는 제공x
public class HideClass implements ObserverInterface {
    @Override
    public void x(){
        System.out.println("x 동작이 실행된다");
    }
    @Override
    public void y(){
        System.out.println("y 동작이 실행된다");
    }
    @Override
    public void z(){
        System.out.println("z 동작이 실행된다");
    }
}
