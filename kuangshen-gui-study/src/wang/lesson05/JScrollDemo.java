package wang.lesson05;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.awt.Container;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 09:37
 **/
public class JScrollDemo extends JFrame {
    public JScrollDemo() {
        Container container = this.getContentPane();
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText("JTextArea");

        JScrollPane scrollPane = new JScrollPane(textArea);

        container.add(scrollPane);


        this.setVisible(true);
        this.setBounds(100, 100, 300, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
