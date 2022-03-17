package chapter3;

public class returnArray {
    static int[] makeArray(){
        int temp[] = new int[5];
        for(int i=0; i<temp.length; i++)
            temp[i] = i;
        return temp;
    }
    public static void main(String[] args){
        int [] intArray;
        intArray = makeArray(); // 메소드가 리턴한 배열 참조
        for (int k: intArray)
            System.out.print(k+" ");

    }
}
