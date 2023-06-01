package main;
import model.MinMaxFinder;

// 배열에 저장된 수중에서 최대값, 최소값을 구하는 클래스
public class MinMaxFinderTest {
    public static void main(String[] args) {
        int[] arr={5,3,9,1,7};
        int min = MinMaxFinder.findMin(arr);
        int max = MinMaxFinder.findMax(arr);
        System.out.println("maximum :"+max);
        System.out.println("minimum :"+min);
    }
}
