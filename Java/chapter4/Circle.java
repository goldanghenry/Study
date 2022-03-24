public class Circle {
    int radius;
    String name;

    Circle(){
        this.radius = 1; name="";
    }
    Circle(int a, String b){
        this.radius = a; this.name = b;
    }

    public double getArea(){
        return 3.14*radius*radius;
    }

    public static void main(String[] args){
        Circle donet = new Circle(4,"도넛");
        double area = donet.getArea();
        System.out.println(donet.name + "의 면적은 " + area);
    }
}