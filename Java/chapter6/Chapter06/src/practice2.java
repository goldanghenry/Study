// 실습 2
// +로 연결된 덧셈식을 Scaanner로 입력받아 (중간에 space) 합과 평균을 출력
import java.util.Scanner;
import java.util.StringTokenizer;


public class practice2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String query = sc.nextLine();
        StringTokenizer st = new StringTokenizer(query, "+");

        int n = st.countTokens();   // 분리된 토큰 개수
        double sum = 0;
        while(st.hasMoreTokens()){
            String token = st.nextToken();  // 토큰 얻기
            token = token.trim();
            sum += Integer.parseInt(token);
        }
        System.out.print("합=" + sum+" 평균=" + (double)sum/n );
        sc.close();
    }
    
}
