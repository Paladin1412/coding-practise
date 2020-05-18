package wang.lesson01;

import java.awt.Color;
import java.awt.Frame;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 11:12
 **/
public class TestFrame {
    public static void main(String[] args) {

        //Frame

        //设置弹窗标题
        Frame frame = new Frame("我的第一个Java图形界面窗口");

        //设置可见性
        frame.setVisible(true);

        //设置弹窗大小
        frame.setSize(400,400);

        //设置背景颜色
        frame.setBackground(Color.WHITE);

        //弹出初始位置
        frame.setLocation(200,200);

        //设置大小固定
        frame.setResizable(false);
    }
}
