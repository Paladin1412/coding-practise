package wang.lesson06;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Container;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 11:14
 **/
public class TestTextDemo01 extends JFrame {
    public TestTextDemo01() {
        Container container = this.getContentPane();

        JTextField textField = new JTextField("Hello");
        JTextField textField1 = new JTextField("world", 20);
        container.add(textField, BorderLayout.NORTH);
        container.add(textField1,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
