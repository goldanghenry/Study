package model;

public class StringUtils {
    // 인스턴스 메서드 : static이 없는, new를 통해 객체를 생성해 사용해야하는 메서드
    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}
