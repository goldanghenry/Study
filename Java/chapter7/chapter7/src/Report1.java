import java.util.*;
public class Report1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> aList = new ArrayList<Integer>();
        int temp;

        // init
        aList.add(10); aList.add(20); aList.add(30); aList.add(40);

        while(true){
            System.out.println("1.ADD   2.REMOVE   3.PRINT POSITION   4.PRINT ALL   5.EXIT");
            System.out.print("실행동작: ");
            switch(sc.nextInt()){
                case 1: // 추가
                System.out.print("입력 값: "); 
                if(!aList.contains(temp = sc.nextInt())){
                    aList.add(temp); 
                } break;

                case 2: // 삭제
                System.out.print("삭제 값: "); 
                temp = sc.nextInt();
                for(int i=0; i<aList.size();i++){
                    if(aList.get(i).equals(Integer.valueOf(temp))){
                        aList.remove(Integer.valueOf(temp));
                    }
                } break;

                case 3: // 검색 -> indexOf(Object o) : 인덱스 리턴, 없으면 -1
                System.out.print("검색 값: ");
                temp = sc.nextInt();
                for(int i=0; i<aList.size();i++){
                    if(aList.get(i).equals(Integer.valueOf(temp))){
                        System.out.println(temp+" 값은 "+ (i+1) +"번째에 위치");
                    }
                } break;

                case 4: // 전체 리스트 출력
                System.out.print("모든 값: " );
                for(int i=0; i<aList.size();i++){
                    System.out.print(aList.get(i)+" ");
                } 
                System.out.println(); break;

                case 5: // 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                sc.close(); System.exit(1); break;

                default: // 예외 처리
                System.out.println("1~5번 중 선택하세요.");
            }
            System.out.println();
        }
    }
}
