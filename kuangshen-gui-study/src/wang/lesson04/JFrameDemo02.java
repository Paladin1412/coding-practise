package wang.lesson04;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Container;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 22:37
 **/
public class JFrameDemo02 {
    public static void main(String[] args) {
        new MyJFrame2().init();
    }
}

class MyJFrame2 extends JFrame {
    public void init() {
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        JLabel label = new JLabel("JLabel");

        this.add(label);

        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = this.getContentPane();
        container.setBackground(Color.YELLOW);
    }
}
