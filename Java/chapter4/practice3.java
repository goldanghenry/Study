// 문제3 Rect 객체 배열을 생성하고, 사용자로부터 4개의 사각형을 입력받아 배열에 저장한 뒤, 
// 배열을 검색하여 사각형 면적의 합을 출력하는 main()메소드를 가진 RectArrya 클래스를 작성하라
import java.util.Scanner;
class Rect {
    private int width, height;
    public Rect(int width, int height){
        this.width = width;
        this.height = height;
    }
    public int getArea() {return width*height;}
}

public class practice3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int w,h;
        Rect a[] = new Rect[4];
        for (int i=0; i<4;i++){
            System.out.print((i+1)+" 너비와 높이 >>");
            w = sc.nextInt(); h = sc.nextInt();
            a[i] = new Rect(w,h);
        }
        System.out.println("저장했습니다.");
        sc.close();
        System.out.println("사각형의 전체 합은"+(a[0].getArea()+a[1].getArea()+a[2].getArea()+a[3].getArea()));
    }
}
