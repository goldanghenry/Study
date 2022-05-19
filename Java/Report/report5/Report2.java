import java.util.*;
public class Report2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> clientList = new HashMap<String, Integer>();
        String name;
        int point;

        System.out.println("** 포인트 관리 프로그램입니다 **");
        while(true){
            System.out.print("이름과 포인트 입력>>");
            name = sc.next();
            if(name.equals("exit")){ 
                System.out.println("프로그램을 종료합니다...");
                sc.close(); System.exit(1);
            }
            point = sc.nextInt();
            
            // clientList 해시맵에 들어 있는 모든 (name, point) 쌍 출력
            Set<String> keys = clientList.keySet(); // 모든 키를 Set 컬렉션에 받아옴
            if(!keys.contains(name)){// 이름이 없다면,
                clientList.put(name, point);
            } 
            else {  // 이름이 있다면
                clientList.put(name, point+clientList.get(name));
            }

            Iterator<String> it = keys.iterator();  // Set에 접근하는 Iterator 리턴
            while(it.hasNext()){
                String key = it.next();
                int value = clientList.get(key);
                System.out.print("("+key+","+ value + ") ");
            }
            System.out.println();
        }   
    }   
}
