class Shape {   // super class
    public void draw(){
        System.out.println("Shape");
    }
}
class Line extends Shape{  
    public void draw(){ // method overriding
        System.out.println("Line");
    }
}
class Rect extends Shape {
    public void draw(){ // method overriding
        System.out.println("Rect");
    }
}
class Circle extends Shape {
    public void draw(){ // method overriding
        System.out.println("Circle");
    }
}

public class MethodOverridingEx {
    static void paint(Shape p){     // Shape을 상속받은 모든 객체들이 매개 변수로 넘어올 수 있음
        p.draw();       // dynamic binding
    }
    public static void main(String[] args){
        Line line = new Line();
        paint(line);    // line의 draw 실행. "Line" 출력

        // 다음 호출들은 모두 paint() 메소드 내에서 Shape에 대한 레퍼런스 p로 업캐스팅됨
        paint(new Shape()); // "Shape"
        paint(new Line());  // "Line"
        paint(new Rect());  // "Rect"
        paint(new Circle());    // "Circle"


    }
}
