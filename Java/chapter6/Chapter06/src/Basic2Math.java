public class Basic2Math {
    private double a;
    private double b;
    public Basic2Math(double a, double b){
        this.a =a; this.b = b;
    }
    public void setA(double a){ this.a =a;} // +getA
    public void setB(double b){ this.b = b;}
    public double sum(){
        return BasicMath.sum(a,b);
    }
    public double sub(){
        return BasicMath.sub(a,b);
    }
    public double mul(){
        BasicMath bm = new BasicMath();
        return bm.mul(a, b);
    }
    // @Override
    // public boolean equals(Object arg0) {
    //     Basic2Math k = (Basic2Math)arg0;
    //     //if(this.a == )
        
    // }
}
