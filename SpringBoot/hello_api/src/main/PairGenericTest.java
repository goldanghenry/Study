package main;

import model.Pair;

public class PairGenericTest {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("hello",1);
        System.out.println("Key: "+pair.getKey());
        System.out.println("Value:"+pair.getValue());
    }
}
