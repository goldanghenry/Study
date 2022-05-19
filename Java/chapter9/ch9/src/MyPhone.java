import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPhone extends JFrame {
    private JPanel lcdJPanel;
    private JTextArea lcdJTextArea;
    private String lcdOutput = "";
    private JPanel keyJPanel;
    private JButton keyJButton[];
    private MyAction myAction[];

    public MyPhone(){
        setTitle("MyPhone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // To do ------------------
        // 1) 상단 lcdJPanel -> JTextArea
        lcdJPanel = new JPanel();
        lcdJPanel.setLayout(new GridLayout(1,1));

        lcdJTextArea = new JTextArea(lcdOutput, 5, 10);
        lcdJPanel.add(lcdJTextArea);

        // 2) 하단 keyJPanel -> keyJButton
        keyJPanel = new JPanel();
        keyJPanel.setLayout(new GridLayout(5,3));

        keyJButton = new JButton[15];
        myAction = new MyAction[15];    // button listener

        // Send, clr, End
        keyJPanel.add(keyJButton[0] = new JButton("Send"));
        keyJButton[0].addActionListener(myAction[0] = new MyAction());
        keyJPanel.add(keyJButton[1] = new JButton("clr"));
        keyJButton[1].addActionListener(myAction[1] = new MyAction());
        keyJPanel.add(keyJButton[2] = new JButton("End"));
        keyJButton[2].addActionListener(myAction[2] = new MyAction());

        // 1~9
        for (int i=3; i<12; i++){
            keyJPanel.add(keyJButton[i] = new JButton(Integer.toString(i-2)));
            keyJButton[i].addActionListener(myAction[i] = new MyAction());
        }

        // *, 0, #
        keyJPanel.add(keyJButton[12] = new JButton("*"));
        keyJButton[12].addActionListener(myAction[12] = new MyAction());
        keyJPanel.add(keyJButton[13] = new JButton("0"));
        keyJButton[13].addActionListener(myAction[13] = new MyAction());
        keyJPanel.add(keyJButton[14] = new JButton("#"));
        keyJButton[14].addActionListener(myAction[14] = new MyAction());

        // 3) Container -> lcdJPanel + keyJPanel
        c.add(lcdJPanel, BorderLayout.NORTH);
        c.add(keyJPanel, BorderLayout.CENTER);

        // --------------------------------
        setSize(300, 500);
        setVisible(true);
        }

        class MyAction implements ActionListener{
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Send")){     // 전화 걸기
                    String callingText ="\n전화 거는 중...";
                    lcdOutput += callingText;
                    lcdJTextArea.setText(lcdOutput);
                }
                else if(b.getText().equals("clr")){ // 마지막 입력 지우기
                    StringBuffer sb = new StringBuffer();
                    sb.append(lcdOutput);   // 버퍼에 현재 String 저장
                    int index = lcdOutput.length()-1;   // 마지막 입력 index
                    sb.deleteCharAt(index); // 버퍼에서 마지막 문자 지우기
                    lcdOutput = sb.toString();  // 버퍼->string 변환해서 다시 저장
                    lcdJTextArea.setText(lcdOutput);
                }
                else if(b.getText().equals("End")){ // 모두 지우기
                    lcdOutput = "";
                    lcdJTextArea.setText(lcdOutput);
                }
                else{   // 버튼의 문자 panel에 입력
                    lcdOutput += b.getText();
                    lcdJTextArea.setText(lcdOutput);
                }
            }
        }
    public static void main(String[] args){
        new MyPhone();
    }
}