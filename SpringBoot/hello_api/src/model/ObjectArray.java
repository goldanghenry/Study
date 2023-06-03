package model;

import java.util.Arrays;

public class ObjectArray {
    private static final int DEFAULT_CAPACITY=5;
    private Object[] elements;
    private int size;

    public ObjectArray(){
        this.elements=new Object[DEFAULT_CAPACITY];
    }

    public int size(){
        return this.size;
    }

    public Object get(int index){
        if (index<0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }
    private void ensureCapacity(){
        int newCapacity = elements.length*2;
        elements = Arrays.copyOf(elements,newCapacity);
    }
    public void add(Object element){
        if(size== elements.length){
            ensureCapacity();
        }
        elements[size++]=element;
    }


}
