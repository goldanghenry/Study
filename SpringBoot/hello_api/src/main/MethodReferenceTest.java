package main;

import model.Converter;
import model.StringUtils;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceTest {
    public static void main(String[] args) {
        // 정적 메서드 참조
        Converter<String,Integer> converter = IntegerUtils::stringToInt;
        Integer result = converter.convert("123");
        System.out.println(result);

        // 인스턴스 메서드 참조
        StringUtils stringUtils = new StringUtils();
        Converter<String, String> converter1 = stringUtils::reverse;
        String result1 = converter1.convert("hello");
        System.out.println(result1);

        // 특정 객체의 인스턴스 메서드 참조
        List<String> names = Arrays.asList("홍길동", "김길동", "이길동");
        names.sort(String::compareTo);
        System.out.println(names);
    }
}
