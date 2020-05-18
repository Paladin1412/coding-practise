package wang.lesson02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 12:24
 **/
public class TestActionEvent {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button button = new Button("点击我输出AAA");

        MyActionListener myActionListener = new MyActionListener();
        button.addActionListener(myActionListener);

        frame.add(button, BorderLayout.CENTER);
        frame.pack();

        windowClose(frame);
        frame.setVisible(true);
    }

    //关闭窗口事件
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

// 事件监听
class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("AAAA");
    }
}
