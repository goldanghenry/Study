// 실습
class MyPoint {
    private int x, y;
    protected MyPoint(){
        this.x = 100; this.y = 200;
    }
    protected void disp(){
        System.out.println("점(x,y)=("+this.x+","+this.y+")");
    }
}

class MyCircle extends MyPoint{
    int r;
    MyCircle(){
        this.r = 50;
    }
    protected void disp(){
        super.disp();
        System.out.println("반지름 r="+r);
    }
}

class MyRect extends MyPoint {
    int w, h;
    MyRect(){
        this.w = 200; this.h = 300;
    }
    protected void disp(){
        super.disp();
        System.out.println("폭 = "+ w +", 높이 = "+ h);
    }
}

public class MainTest {
    public static void main(String[] args){
        MyCircle c = new MyCircle();
        c.disp();
        MyRect r = new MyRect();
        r.disp();
    }
}
