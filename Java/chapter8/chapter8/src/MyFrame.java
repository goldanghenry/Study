import javax.swing.*;

public class MyFrame extends JFrame{
    public MyFrame(){   // 생성자
        setTitle("300x300 스윙 프레임 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 버튼이 클릭될 때 프로그램과 함께 종료
        setSize(300,300);
        setVisible(true);   // 없으면 안보임
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
