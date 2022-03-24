// 문제1
class Song {
    private String name;
    Song(String n){
        this.name = n;
    }
    public String getTitle(){
        return this.name;
    }
}

public class practice1 {
    public static void main(String[] args){
        Song mySong = new Song("Nessum Dorma");
        Song yourSong = new Song("공주는 잠 못 이루고");
        System.out.println("내 노래는 "+mySong.getTitle());
        System.out.println("너의 노래는 "+yourSong.getTitle());
    }
}