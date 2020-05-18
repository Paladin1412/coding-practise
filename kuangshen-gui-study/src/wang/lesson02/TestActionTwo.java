package wang.lesson02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 多个按钮共享一个事件
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 12:33
 **/
public class TestActionTwo {
    public static void main(String[] args) {
        //两个按钮实现同一个监听
        //开始 停止
        Frame frame = new Frame("开始-停止");

        Button start = new Button("start");
        Button stop = new Button("stop");


        MyMonitor myMonitor = new MyMonitor();
        start.addActionListener(myMonitor);

        stop.addActionListener(myMonitor);

        frame.add(start, BorderLayout.NORTH);
        frame.add(stop, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}

class MyMonitor implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被点击了=>" + e.getActionCommand());
    }
}
