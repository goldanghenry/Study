public class MusicInstance {
    public static void main(String[] args){
        Music m = new Music("흥부전", 1700);
        Classic c = new Classic("캐논", 1732, "파핼벨");
        Pop p = new Pop("바람이 분다", 2004, "이소라");
        System.out.println(m);
        System.out.println(c);
        System.out.println(p);
        Music musics [] = new Music[3];
        musics[0] = m; musics[1] = c; musics[2] = p;    // 업 캐스팅

        for(int i=0; i<musics.length;i++){ // 다운 캐스팅
            if(musics[i] instanceof Classic){
                Classic c_music  = (Classic)musics[i];
            }
            else if(musics[i] instanceof Pop){
                Pop p_music = (Pop)musics[i];
            }
        }
        // 출력
        for(int i=0; i<musics.length;i++) {
            System.out.println(musics[i].getClass().getName());
        }
    }
}
