package main;

import model.IntArray;

public class MyIntArrayTest {
    public static void main(String[] args){
        IntArray list = new IntArray();
        list.add(6);
        list.add(7);
        list.add(8);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        System.out.println(list.size());

    }
}
