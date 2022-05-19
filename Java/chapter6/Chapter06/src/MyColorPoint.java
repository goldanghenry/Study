abstract class MyPoint{
    private int x;
    private int y;
    public MyPoint(int x, int y){ this.x=x; this.y=y;}
    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    protected abstract void move(int x, int y); // 새로운 x,y 위치로 이동
    protected abstract void reverse();  // (x,y) 에서 (y,x)로 위치 변경
    protected void show(){ System.out.print(this.x+", "+this.y);}
}

public class MyColorPoint extends MyPoint {
    private String color;
    public MyColorPoint(int x, int y, String color){
        super(x,y);
        this.color = color;
    }
    @Override
    protected void move(int x, int y){ setX(x); setY(y); }
    @Override
    protected void reverse(){
        int temp = getX();
        setX(getY());
        setY(temp);
    }
    public void show(){
        super.show();
        System.out.print(", "+this.color);
    }
    public static void main(String[] args){
        MyPoint p = new MyColorPoint(2,3,"blue");
        p.move(3,4);
        p.reverse();
        p.show();   // 이 메소드의 실행 결과 "4, 3, blue"가 출력
    }
}
