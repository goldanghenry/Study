// 실습2
interface Payable{
    String play();
}
abstract class Music1 implements Payable {
    String name;
    int year;
    Music1(String name, int year){ this.name = name; this.year = year;  }
    String getName(){ return this.name; }
    public int getYear(){ return this.year; }
    public void printMusic(){ System.out.println("곡명 = "+this.name+", 연도 = "+this.year); }
}

class Classic1 extends Music1  {
    String composer;
    Classic1(String name, int year, String composer){
        super(name, year);
        this.composer = composer;
    }
    public String play() { return getName()+"을 연주합니다.";  }
    public String getComposer(){ return this.composer; }
    public void printMusic(){
         System.out.println("곡명 = "+this.name+", 연도 = "+this.year+", 작곡가 = "+this.composer);
    }
}
class Pop1 extends Music1  {
    String singer;
    Pop1(String name, int year, String singer){
        super(name, year);
        this.singer = singer;
    }
    public String play() { return getName()+"을 연주합니다."; }
    public String getSinger(){ return this.singer; }
    public void setSinger(String singer){ this.singer = singer; }
    public void printMusic(){ System.out.println("곡명 = "+this.name+", 연도 = "+this.year);  }
}


public class PayableInterfaceTest {
    public static void main(String[] args){
        Classic1 classic = new Classic1("캐논", 1732, "파헬밸");
        classic.printMusic();
        System.out.println(classic.play());
    }
}
