class Music {
    protected String name; int year;
    Music(String name, int year){ 
        this.name = name; this.year=year;
    }
    @Override
    public String toString() {
        return "Music [ 곡명 = " + this.name + ", 연도 = " + this.year + " ]";
    }
}
class Classic extends Music {
    private String composer;
    Classic(String name, int year, String composer){
        super(name, year);
        this.composer = composer;
    }
    @Override
    public String toString(){
        return "Classic [ 곡명 = " + this.name + ", 연도 = " + this.year + ", 작곡가= "+composer+" ]";
    }
}
class Pop extends Music {
    private String singer;
    Pop(String name, int year, String singer){
        super(name, year);
        this.singer = singer;
    };
    @Override
    public String toString(){
        return "Pop [ 곡명 = " + this.name + ", 연도 = " + this.year + ", 가수= "+singer+" ]";
    }
}
public class MusicTester {
    public static void main(String[] args){
        Music m = new Music("흥부전", 1700);
        Classic c = new Classic("운명", 1808, "베토벤");
        Pop p = new Pop("보헤미안 랩소디", 1980, "퀸");

        System.out.println(m);
        System.out.println(c);
        System.out.println(p);
    }
}
