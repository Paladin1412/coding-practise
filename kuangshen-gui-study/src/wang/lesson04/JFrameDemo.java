package wang.lesson04;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.Color;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 22:37
 **/
public class JFrameDemo {

    //init() 初始化
    public void init() {

        //JFrame是顶级窗口
        JFrame frame = new JFrame("这是一个JFrame窗口");
        frame.setVisible(true);
        frame.setBounds(100, 100, 300, 300);
        frame.setBackground(Color.CYAN);

        JLabel label = new JLabel("JLabel");

        frame.add(label);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        //建立一个窗口
        new JFrameDemo().init();
    }
}
