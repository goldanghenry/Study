import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Report12 extends JFrame {
    Report12() {
        super("스레드를 가진 겜블링");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel()); // GamePanel을 컨텐트팬으로 등록
        setSize(300, 200);
        setVisible(true);
    }

    class GamePanel extends JPanel {
        // 화면 디자인
        JLabel[] label = new JLabel[3]; // 3개의 레이블
        JLabel result = new JLabel("마우스를 클릭할 때마다 게임합니다."); // 결과 출력
        JLabel gameState = new JLabel("GAME : OFF");   // 게임 시작 상태 표시
        /* TO DO 스레드(thread) 생성 */
        public GamePanel() {
            setLayout(null); // 절대 위치에 컴포넌트 배치
            for (int i = 0; i < label.length; i++) {
                label[i] = new JLabel("0"); // 초기 레이블 생성
                label[i].setSize(60, 30); // 레이블 크기
                label[i].setLocation(30 + 80 * i, 50); // 레이블 위치
                label[i].setHorizontalAlignment(JLabel.CENTER);
                label[i].setOpaque(true); // 레이블에 배경색 설정이 가능하도록 설정
                label[i].setBackground(Color.MAGENTA);
                label[i].setForeground(Color.YELLOW);
                label[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
                add(label[i]);
            }
            gameState.setHorizontalAlignment(JLabel.NORTH_EAST); // 게임 상태를 표시할 레이블 생성
            gameState.setSize(250, 20);
            gameState.setLocation(215, 5);
            add(gameState);

            result.setHorizontalAlignment(JLabel.CENTER); // 결과를 출력할 레이블 생성
            result.setSize(250, 20);
            result.setLocation(15, 120);
            add(result);
            GamblingThread thread = new GamblingThread(label, result, gameState);
            /* TO DO 쓰레드 시작 */
            addMouseListener(new MouseAdapter() { // 마우스 리스너 구현
                public void mousePressed(MouseEvent e) {
                    if ((thread).isReady())
                        thread.startGambling();
                }
            });

            addKeyListener(new KeyAdapter() { // 키 리스너 구현
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if (keyCode == KeyEvent.VK_ENTER) {
                        if (thread.gambling == true) {
                            thread.reTry = true;
                        }
                    }
                }
            });
            setFocusable(true);
            requestFocus();
            thread.start();
        }
    }

    class GamblingThread extends Thread {
        JLabel[] label; // 게임 숫자를 출력
        JLabel result; // 결과를 출력
        JLabel gameState;   // 게임 상태
        long delay = 200;// 지연시간(sleep) 값
        boolean gambling = false; // 게임을 할 것인지 결정
        boolean reTry = false; // 엔터키가 입력되면 랜덤으로 숫자 생성

        public GamblingThread(JLabel[] label, JLabel result, JLabel gameState) {
            // TO DO
            this.label = new JLabel[3];
            this.label = label;
            this.result = result;
            this.gameState = gameState;
        }

        boolean isReady() {
            return !gambling; // 게임 중이면 준비되지 않았음
        }

        synchronized public void waitForGambling() {// 게임하지 않으면 기다림
            // TO DO
            if (!gambling) {
                try {
                    wait();
                } catch (InterruptedException e) {  }
            }
        }

        synchronized public void startGambling() {
            // 마우스 클릭으로 게임을 진행
            gambling = isReady();
            notify();
            this.gameState.setText("GAME : ON");
            this.result.setText("<Enter>키를 눌러 슬롯을 돌려주세요.");
        }
        // 대기 상태 -> 마우스 클릭 -> startgambling(); -> enter : 난수 생성
        public void run() {
            // 게임을 진행
            while (true) {
                // - 무한루핑을 돌림
                // - waitForGambling(); (마우스 클릭에 의해 게임 진행 지시를 기다림)
                // - 0~4까지의 랜덤 수를 label에 넣음(첫번째, 두번째, 세번째 동일)
                // - 게임이 성공했는지 판별: if(첫번째수 == 두번째수 && 두번째수 == 세번째수)
                // - gambling = false; (스톱하여 다음 게임이 가능하도록 설정)
                // - if 면 게임 종료 else.
                waitForGambling();
                try {
                    if (reTry) {
                        Random r = new Random();
                        label[0].setText(Integer.toString(r.nextInt(5)));
                        sleep(delay);
                        label[1].setText(Integer.toString(r.nextInt(5)));
                        sleep(delay);
                        label[2].setText(Integer.toString(r.nextInt(5)));
                        sleep(delay);
                        reTry = false;
                        if (label[0].getText().equals(label[1].getText())
                                && label[1].getText().equals(label[2].getText())) {
                            result.setText("축하합니다!! 다시 게임을 하려면 클릭하세요!");
                            gambling = isReady();
                            this.gameState.setText("GAME : OFF");
                        } else {
                            result.setText("아쉽군요, <Enter>를 눌러 재도전 하세요!");
                        }
                    }

                } catch (InterruptedException e) { return; }
            }
        }
    }

    public static void main(String[] arg) {
        new Report12();
    }
}