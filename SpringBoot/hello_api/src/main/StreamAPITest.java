package main;
/*
스트림API의 이해
배열을 스트림으로 변환 : 배열의 원소들을 스트림 형태로 변환하여 처리할 수 있게 하는 것
스트림은 원본 데이터를 변경하지 않고, 필요한 데이터 처리 작업을 적용한 결과를 생성하기 때문에
인덱스를 통한 직접 접근은 제공하지 않는다.
- 데이터의 흐름을 다루기 유용
- 필터링, 매핑, 정렬 등 다양한 데이터 처리 작업과 최종 결과를 배열이나 컬렉션으로 변환할 수 있다.
- 데이터처리 작업을 연속적인 파이프라인으로 나타낼 수 있어 가독성을 높이고, 병렬처리를 쉽게 구현할 수 있다.
*/

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamAPITest {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};

        // 기존 방식
        int even=0;
        for(int num:numbers){
            if(num%2==0){ even+=num;}
        }

        // Stream API를 활용
        //IntStream stream= Arrays.stream(numbers);
        int sumOfEvens=Arrays.stream(numbers)
                .filter(n->n%2==0)
                .sum();
        System.out.println(even);

        int[] arrOfEvens = Arrays.stream(numbers)
                .filter(n->n%2==0)
                .toArray();

        for(int num:arrOfEvens){
            System.out.print(num+" ");
        }

    }
}
