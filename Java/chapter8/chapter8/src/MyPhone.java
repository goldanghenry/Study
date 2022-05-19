import javax.swing.*;
import java.awt.*;

public class MyPhone extends JFrame {
    private JPanel lcdJPanel;
    private JTextArea lcdJTextArea;
    private String lcdOutput = "";
    private JPanel keyJPanel;
    private JButton keyJButton[];

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
        keyJPanel.add(keyJButton[0] = new JButton("Send"));
        keyJPanel.add(keyJButton[1] = new JButton("clr"));
        keyJPanel.add(keyJButton[2] = new JButton("End"));
        for (int i=3; i<12; i++){
            keyJPanel.add(keyJButton[i] = new JButton(Integer.toString(i-2)));
        }
        keyJPanel.add(keyJButton[12] = new JButton("*"));
        keyJPanel.add(keyJButton[13] = new JButton("0"));
        keyJPanel.add(keyJButton[14] = new JButton("#"));

        // 3) Container -> lcdJPanel + keyJPanel
        c.add(lcdJPanel, BorderLayout.NORTH);
        c.add(keyJPanel, BorderLayout.CENTER);

        // --------------------------------
        setSize(300, 500);
        setVisible(true);
        }
    public static void main(String[] args){
        new MyPhone();
    }
}