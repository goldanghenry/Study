package model;

import java.util.Arrays;

public class IntArray {
    private static final int DEFAULT_CAPACITY = 5;
    private int[] elements;
    private int size=0;

    public IntArray(){
        elements = new int[DEFAULT_CAPACITY];
    }

    public int size(){
        return size;
    }

    public int get(int index){
        if(index<0 || index >=size) {
            throw new IndexOutOfBoundsException("범위초과");
        }
        return elements[index];
    }
    private void ensureCapacity(){
        int newCapacity = elements.length*2;
        elements = Arrays.copyOf(elements,newCapacity);

    }
    public void add(int element){
        if(size== elements.length){
            ensureCapacity();
        }
        elements[size++] = element;
    }
}
