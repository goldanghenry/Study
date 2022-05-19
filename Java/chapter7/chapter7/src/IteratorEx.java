import java.util.*;

public class IteratorEx {
    public static void main(String[] args){
        Vector<Integer> v = new Vector<Integer>();  // vector 대신 ArrayList, Hashset 가능
        v.add(5);
        v.add(4);
        v.add(-1);
        v.add(2,100);   // 4와 -1 사이에 정수 100 삽입  Hashset은 중복은 하나로, 순서도 뒤바뀜.

        // iterator를 이용한 모든 정수 출력하기
        Iterator<Integer> it = v.iterator();    // Iterator(); 객체 얻어오기
        while(it.hasNext()){
            int n = it.next();
            System.out.println(n);
        }

        // iterator를 이용해 합 구하기
        int sum = 0;
        it = v.iterator();
        while(it.hasNext()){
            int n = it.next();
            sum += n;
        }
        System.out.print(sum);
    }
}
