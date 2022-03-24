// 문제 4. 박스 그리기
public class practice4 {    // 박스의 너비와 높이
    private int width, height;  // 박스를 그리는 데 사용하는 문자
    private char fillChar; 
    public  practice4(){    // 매개 변수 없는 생성자. 10x1d의 박스 생성, this()를 이용해 완성
        this(10,1);
    }
    public practice4(int w, int h){ // 너비, 높이의 두 매개 변수를 가진 생성자
        this.width = w;             // this 래퍼런스를 이용하라
        this.height = h;
    }
    public void draw() {    // 박스를 그리는 메소드
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                System.out.print(this.fillChar);
            }
            System.out.println();
        }
    }
    public void fill(char c){   // 박스를 그리는데 사용하는 문자 설정
        this.fillChar = c;
    }
    public static void main(String[] args){
        practice4 a = new practice4();
        practice4 b = new practice4(20,3);
        a.fill('*');
        b.fill('%');
        a.draw();
        b.draw(); 
    }

}
