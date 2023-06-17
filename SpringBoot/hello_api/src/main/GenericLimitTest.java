package main;

import model.AverageCalculator;

public class GenericLimitTest {
    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5};
        Double[] doubles = {1.0,2.0,3.0,4.0,5.0};

        AverageCalculator<Integer> integerAverageCalculator = new AverageCalculator<>(integers);
        Double integerAverage = integerAverageCalculator.calculateAverage();
        System.out.println("Integer average:"+integerAverage);

        AverageCalculator<Double> doubleAverageCalculator = new AverageCalculator<>(doubles);
        Double doubleAverage = doubleAverageCalculator.calculateAverage();
        System.out.println("Double average:"+doubleAverage);
    }
}
