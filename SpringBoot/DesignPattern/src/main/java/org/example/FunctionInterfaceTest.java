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

@FunctionalInterface
interface MathOperation {
    int operation(int x, int y);
}

//public class FunctionInterfaceTest1 implements MathOperation {
//    public static void main(String[] args) {
//        MathOperation mo = new FunctionInterfaceTest();
//        int result = mo.operation(10,20);
//        System.out.println("10+20 =" +result);
//    }
//    @Override
//    public int operation(int x, int y) {
//        return x+y;
//    }
//}

public class FunctionInterfaceTest {
    public static void main(String[] args){
        MathOperation mo = new MathOperation(){
            @Override
            public int operation(int x, int y) {
                return x+y;
            }
        };
        int result = mo.operation(10,20);
        System.out.println("10 + 20 =" + result);
    }
}
