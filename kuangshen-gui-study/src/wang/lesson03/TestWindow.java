package wang.lesson03;

import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 22:09
 **/
public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

class WindowFrame extends Frame {
    public WindowFrame() {
        setBackground(Color.BLUE);
        setBounds(100, 100, 200, 200);
        setVisible(true);

        // 匿名内部类
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }
        });
    }
}
