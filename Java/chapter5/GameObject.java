/*  bear의 fish 먹기 게임
이 게임엔 bear와 fish객체가 등장, 이들은 10행 20열의 격자판에서 각각 정해진 규칙에 의해 움직인다.
- bear는 사용자의 키에 의해 왼쪽(a 키), 아래(s 키), 위(w 키), 오른쪽(d 키)으로 한 칸씩 움직이고,
- fish는 다섯 번 중 세 번은 제자리에 있고, 나머지 두 번은 4가지 방향 중 랜덤하게 한 칸씩 움직인다.
- 키가 입력될 때마다 bear와 fish 객체의 move()가 순서대로 호출된다.
- 게임은 bear가 fish를 먹으면(fish위치로 이동) 성공으로 끝난다.
다음은 각 객체의 이동을 정의하는 move()와 각 객체의 모양을 정의하는 getShape()를 추상 메소드로 가진 추상 클래스 GameObject이다.
GameObject를 상속받아 bear와 fish 클래스를 작성하라. 그리고 전체적인 게임을 진행하는 Game 클래스와 main()함수를 작성하고 프로그램을 완성하라.
*/

import java.util.Scanner;
import java.util.Random;

public abstract class GameObject {  // 추상 클래스, 슈퍼 클래스
    Scanner sc = new Scanner(System.in);
    protected int distance;     // 한 번 이동 거리( 2일 경우 2칸을 움직일 수 있게)
    protected int x, y;         // 현재 위치(화면 맵 상의 위치), x축 : 행, y축 : 열

    public GameObject(int startX, int startY, int distance){    // 초기 위치와 이동거리 설정
    this.x = startX; this.y = startY; this.distance = distance;
    }
    public int getX(){return this.x;}   // abstract가 아니기 때문에 바디를 넣어야 한다.
    public int getY(){return this.y;}
    public boolean collide(GameObject p){   // 이 객체가 객체 p와 충돌했으면 true 리턴
        if(this.x == p.getX() && this.y == p.getY()) return true;
        else return false;
    }
    protected abstract void move();     // 이동한 후의 새로운 위치로 x,y 변경
    protected abstract char getShape(); // 객체의 모양을 나타내는 문자 리턴

    public static void main(String[] args){
        Game game1 = new Game();
        game1.start();
    }
}

class Bear extends GameObject{
    protected char shape;
    Bear(int startX, int StartY, int distance, char c){
        super(startX, StartY, distance);
        this.shape = c;
    }
    @Override
    public int getX(){return this.x;}
    @Override
    public int getY(){return this.y;}
    @Override
    public boolean collide(GameObject p){
        if(this.x == p.getX() && this.y == p.getY()) return true;
        else return false;
    }
    @Override   
    public void move(){ // 입력 -> 옮기기
        System.out.print("위(w), 아래(s), 왼쪽(a), 오른쪽(d) >> ");
        char movement = sc.next().charAt(0);
        switch(movement){
            case 'w': this.x--; break;
            case 's': this.x++; break;
            case 'a': this.y--; break;
            case 'd': this.y++;
        }
    }
    @Override
    public char getShape(){ return this.shape; }    // 출력할 때 사용
}

class Fish extends GameObject{
    protected char shape;
    Fish(int startX, int StartY, int distance, char c){
        super(startX, StartY, distance);
        this.shape = c;
    }
    @Override
    public int getX(){return this.x;}
    @Override
    public int getY(){return this.y;}
    @Override
    public void move(){
        Random Rf = new Random();
        switch(Rf.nextInt(4)){
            case 0: {
                if(this.x - this.distance >= 0){    // map을 벗어나는 경우 움직이지 않는다
                this.x -= this.distance ; break;
                }
            }
            case 1: {
                if(this.x + this.distance < 10){
                this.x += this.distance ; break;
                }
            }
            case 2: {
                if(this.y - this.distance >= 0){
                this.y -= this.distance ; break;
                }
            }
            case 3: {
                if(this.y + this.distance < 20){
                this.y += this.distance ;
                }
            }
        }
    }
    @Override
    public char getShape(){ return this.shape; }    // 출력할 때 사용
}

class printMap{ // printMap method : 이동거리를 다 움직였거나, fish를 잡았을 때 출력
    void print(int Bx, int By, char Bs, int Fx, int Fy, char Fs){
        System.out.println();
        for(int i=0; i<10;i++){
            for(int j=0; j<20; j++){
                if(Bx == i && By == j) System.out.print(Bs);
                else if (Fx == i && Fy == j) System.out.print(Fs);
                else System.out.print('-');
            }
            System.out.println();
        }
    }   
}    
class Game{ // 물고기는 3번 기다리고 2번 움직임
    void start(){
        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다. **\n");

        // 객체 생성
        Bear B; Fish F;
        Random R = new Random();
        printMap P = new printMap();
        
        // 랜덤으로 위치 배정
        B = new Bear(R.nextInt(10), R.nextInt(20), 1, 'B'); // Bear
        F = new Fish(R.nextInt(10), R.nextInt(20), 1, '@'); // Fish
        
        int count=0;// count는 Fish의 움직임을 위함
        while(true){
            // 맵 출력
            P.print(B.getX(), B.getY(), B.getShape(), F.getX(), F.getY(), F.getShape());

            // 사용자 입력
            B.move();
            
            // Bear가 Fish를 먹었는지 검사
            if(B.collide(F) == true) {
                P.print(B.getX(), B.getY(), B.getShape(), F.getX(), F.getY(), F.getShape());
                System.out.println("Bear Wins!!");
                break;
            }
            count++;
            if(count%3 ==0 || count%4 ==0){ // Bear가 5번 움직일 때, Fish는 3번은 제자리, 2번은 랜덤하게 움직임
                F.move();
            }
        }
    }
}
