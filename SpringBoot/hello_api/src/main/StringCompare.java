package main;

public class StringCompare {
    public static void main(String[] args) {
        String str1="Hello";
        String str2="World";

        // equals
        if (str1.equals(str2)){
            System.out.println("두 문자열은 같습니다.");
        } else {
            System.out.println("두 문자열은 다릅니다.");
        }

        // compareTo()
        String str3 = "apple";
        String str4 ="banana";

        int result = str3.compareTo(str4);

        if (result == 0){
            System.out.println("두 문자열은 같습니다.");
        } else if(result < 0){
            System.out.println("str3이 str4보다 앞에 있습니다.");
        } else{
            System.out.println("str3이 str4보다 뒤에 있습니다.");
        }


    }
}
