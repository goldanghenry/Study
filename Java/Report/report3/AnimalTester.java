// 2014097056 심화컴퓨터공학 우성현
// 1. 아래의 주어진 Animal Class를 상속하여 Dog Class를 완성하시오. 
// bark()를 overriding하여 출력결과와 같이 출력하는 프로그램을 구현하시오.
public class AnimalTester {
    public static void main(String[] args){
        Dog d = new Dog("강아지");

        System.out.println("동물 : " + d.getName());
        System.out.println("울음소리 : " + d.bark());
    }
}
