package org.example;

class ObjectArray<T> {
    private T[] array;
    public ObjectArray(int size){
        // 제네릭 배열을 생성하는 방법은 배열을 생성한 후 형변환을 해야 한다.
        array = (T[]) new Object[size];
    }
    public void set(int index, T value){
        array[index] = value;
    }
    public T get(int index){
        return array[index];
    }

    public int size(){
        return array.length;
    }
}

class Pair<K,V> {
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }

    public void setKey(K key){
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
class AverageCalculator<T extends Number> {
    private T[] numbers;
    public AverageCalculator(T[] numbers){
        this.numbers = numbers;
    }
    public double calculateAverage(){
        double sum = 0.0;
        for (T number : numbers){
            sum += number.doubleValue();
        }
        return sum / numbers.length;
    }
}

public class GenericTest {
}
