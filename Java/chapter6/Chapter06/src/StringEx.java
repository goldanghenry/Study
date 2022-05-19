import java.util.StringTokenizer;

public class StringEx {
    public static void main(String[] args){
        String a = new String(" C#");
        String b = new String(",C++");

        System.out.println(a+"의 길이는 " + a.length());    // 문자열의 길이 : 3
        System.out.println(a.contains("#"));    // 문자열 포함관계 true

        a = a.concat(b);    // 문자열 연결 : " C#,C++"
        a = a.trim();       // 문자열 앞 뒤의 공백 제거: "C#,C++"
        a = a.replace("C#", "Java");    // 문자열 대치 : "Java,C++"
        String s[] = a.split(",");      // 문자열 분리 : s[0] = "Java", s[1] = "C++"
        a = a.substring(5); // 인덱스 5부터 끝까지 서브 스트링 리턴 : "C++"
        char c = a.charAt(2);   // 인덱스 2의 문자 리턴 : '+'

        StringBuffer sb = new StringBuffer("This"); // "Java"를 가진 StringBuffer 객체 생성
        sb.append(" is pencil.");   // sb = "This is pencil."
        sb.insert(7, " my");        // sb = "This is my pencil."
        sb.replace(8,10,"your");    // sb = "This is your pencil."

        StringTokenizer st = new StringTokenizer("2+3+4+6", "+");
        int n = st.countTokens();
        System.out.println("토큰 개수 = "+n);
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken()+" ");
        }



    }
}
