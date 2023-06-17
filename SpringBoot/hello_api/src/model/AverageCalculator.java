package model;

public class AverageCalculator<T extends Number> {
    private T[] numbers;

    public AverageCalculator(T[] numbers){
        this.numbers = numbers;
    }
    public Double calculateAverage(){
        Double sum = 0.0;
        for(T number : numbers){
            sum+=number.doubleValue();
        }
        return sum/numbers.length;
    }


}
