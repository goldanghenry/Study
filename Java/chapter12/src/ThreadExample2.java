import java.awt.Toolkit;

public class ThreadExample2 {
	public static void main(String[] args) {
		Thread th = new BeepTask();
        th.start();
		// 띵 문자열을 5번 반복해서 출력하는 작업
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

class BeepTask extends Thread { // Thread 상속 받음
    @Override
    public void run(){  // 런에 내용 넣기
        Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
    }
}