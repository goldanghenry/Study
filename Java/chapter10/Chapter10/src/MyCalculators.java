// 과제10, 2014097056 심화컴퓨터공학 우성현
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyCalculators extends JFrame {
    private JPanel lcdJPanel;
    private JPanel keyJPanel;
    private JTextField historyTextArea;
    private JTextField currentTextArea;
    private JButton keyJButton[];
    private Font bigFont;
    private String pre_history = "0";   // 이전 String 기억
    private String history = "0";
    private String currentInput = "";
    private String stack ="";           // 연산자 기록
    private double pre_result = 0.0;    // 이전 result 기억
    private double result = 0.0;

    public MyCalculators(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        MyActionListener listener = new MyActionListener(); // 버튼용 리스너 객체 생성

        // 상단 lcdJPanel
        lcdJPanel = new JPanel();
        lcdJPanel.setLayout(new GridLayout(2,1,0,0));

        historyTextArea = new JTextField(history,1);
        bigFont = historyTextArea.getFont().deriveFont(Font.PLAIN, 18f); // 폰트 값 설정
        historyTextArea.setFont(bigFont);
        lcdJPanel.add(historyTextArea);
        
        currentTextArea = new JTextField(currentInput,2);
        currentTextArea.setFont(bigFont);
        currentTextArea.setHorizontalAlignment(JTextField.RIGHT);   // 텍스트필드 우측 정렬
        lcdJPanel.add(currentTextArea);

        // KeyPanel
        keyJPanel = new JPanel();
        keyJPanel.setLayout(new GridLayout(5,4));
        keyJButton = new JButton[18];

        // 버튼용 string array
       String [] ButtonName = {"7", "8", "9", "/",
                               "4", "5", "6", "*", 
                               "1", "2", "3", "-",
                               "0", ".", "=", "+", 
                               "C", "B"};

        // 버튼 생성                               
        for(int i=0; i<18;i++){
            keyJPanel.add(keyJButton[i] = new JButton(ButtonName[i]));
            keyJButton[i].setFont(bigFont);
            keyJButton[i].addActionListener(listener);
        }

        c.add(lcdJPanel, BorderLayout.NORTH);
        c.add(keyJPanel, BorderLayout.CENTER);
         // --------------------------------
         setSize(350, 300);
         setVisible(true);
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JButton b = (JButton)e.getSource();
            String s = b.getText();
            String temp = "";
            boolean err_check = true;   // ZeroDivisionError check

            // 1. BTN : +, -, *, /
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                if(currentInput.equals("0으로 나눌 수 없습니다.")) currentInput = "";
                else{ // history에 연산자가 붙어 있다면 pre_history에는 연산자를 떼고 저장
                    if(history.length()>3) pre_history = history.substring(0, (history.length()-2));
                    else pre_history = history;
                    pre_result = result;
                    if(stack.equals("") && !currentInput.equals("")){ // 결과값에 덧 씌우기
                        result = 0.0;
                        history = "";   // 초기화
                    }
                    if(currentInput.equals("")){    // 결과값에 연산자가 입력되는 경우 -> 이어서 계산
                        stack = s;
                        currentInput = s;
                        history += " " + s +" ";
                        currentInput = "";
                    }
                    else {
                        if(stack.equals("")) result = Double.parseDouble(currentInput);
                        else if(stack.equals("+")) result += Double.parseDouble(currentInput);
                        else if(stack.equals("-")) result -= Double.parseDouble(currentInput);
                        else if(stack.equals("*")) result *= Double.parseDouble(currentInput);
                        else if(stack.equals("/")) {
                            if(Double.parseDouble(currentInput) == 0.0) {
                                currentInput = "0으로 나눌 수 없습니다.";
                                err_check = false;
                            }
                            else result /= Double.parseDouble(currentInput);
                        }
                        if(err_check){
                            stack = s;
                            history += currentInput + " " + s +" ";
                            currentInput ="";
                        }
                    }
                }
            }
            // 2. BTN : =
            else if(s.equals("=")){
                if(history.length()>3) pre_history = history.substring(0, (history.length()-2));
                else pre_history = history;
                pre_result = result;
                
                if(currentInput.equals("")) currentInput="0";
                if(stack.equals("+")) result += Double.parseDouble(currentInput);
                else if(stack.equals("-")) result -= Double.parseDouble(currentInput);
                else if(stack.equals("*")) result *= Double.parseDouble(currentInput);
                else if(stack.equals("/")) {
                    if(Double.parseDouble(currentInput) == 0.0) {
                        currentInput = "0으로 나눌 수 없습니다.";
                        err_check = false;
                    }
                    else result /= Double.parseDouble(currentInput);
                }
                else if(stack.equals("")&& Double.parseDouble(currentInput)>0) result = Double.parseDouble(currentInput);
                if((result - (int)result)==0.0) history = Integer.toString((int)result); // 정수로 출력
                else history = Double.toString(result);
                if(err_check){
                    currentInput="";
                    stack = "";
                }
            }
            // 3. BTN : .
            else if(s.equals(".")){
                currentInput+=".";
            }
            // 4. BTN : Clear
            else if(s.equals("C")){
                if(history.length()>3) pre_history = history.substring(0, (history.length()-2));
                else pre_history = history;
                pre_result =result;
                currentInput = "";
                history ="0";
                result = 0.0;
                stack = "";
            }
            // 5. BTN : Back
            else if(s.equals("B")){
                history = pre_history;
                result = pre_result;
                currentInput = "";
            }
            // 6. BTN : 숫자키
            else {
                if(currentInput.equals("0으로 나눌 수 없습니다.")) currentInput = "";
                for(int i=0; i<10;i++){
                    if(s.equals(temp = Integer.toString(i))){
                        currentInput+=temp;
                    }
                }
            }
            historyTextArea.setText(history);
            currentTextArea.setText(currentInput);
        }
    }

    public static void main(String[] args){
        new MyCalculators();
    }
}