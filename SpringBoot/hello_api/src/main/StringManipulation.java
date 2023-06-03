package main;

public class StringMainipulation {
    public static void main(String[] args) {
        String str = new String("Hello World");
        char firstChar = str.charAt(0);
        String replaceString = str.replace('o',' ');
        int index = str.indexOf('W');
        int length = str.length();
        String upperCase = str.toUpperCase();
        String lowerCase = str.toLowerCase();
        String substring = str.substring(5);

        System.out.println(firstChar);
        System.out.println(replaceString);
        System.out.println(index);
        System.out.println(length);
        System.out.println(upperCase);
        System.out.println(lowerCase);
        System.out.println(substring);
    }
}
