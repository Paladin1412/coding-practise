package wang.lesson01;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Description: panel可以看成是一个空间 但不能单独存在
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 11:37
 **/
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel();


        //设置布局
        frame.setLayout(null);

        frame.setBounds(200, 200, 200, 200);
        frame.setBackground(new Color(40, 161, 35));

        panel.setBounds(50, 50, 100, 100);
        panel.setBackground(new Color(248, 0, 0));

        frame.add(panel);

        frame.setVisible(true);

        //监听事件 监听窗口关闭事件 System.exit(0)
        //适配器模式
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
