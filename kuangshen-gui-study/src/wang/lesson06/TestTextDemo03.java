package wang.lesson06;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Container;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 11:14
 **/
public class TestTextDemo03 extends JFrame {
    public TestTextDemo03() {
        Container container = this.getContentPane();

        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setEchoChar('*');

        container.add(jPasswordField);
        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TestTextDemo03();
    }
}
