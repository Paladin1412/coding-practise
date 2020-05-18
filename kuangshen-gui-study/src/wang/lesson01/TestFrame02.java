package wang.lesson01;

import java.awt.Color;
import java.awt.Frame;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 11:28
 **/
public class TestFrame02 {
    public static void main(String[] args) {
        //展示多个窗口
        new MyFrame(100,100,100,100,Color.blue);
        new MyFrame(200,100,100,100,Color.yellow);
        new MyFrame(100,200,100,100,Color.red);
        new MyFrame(200,200,100,100,Color.white);
    }
}

class MyFrame extends Frame {
    static int id = 0; //可能存在多个窗口 需要一个计数器

    public MyFrame(int x, int y, int w, int h, Color color) {
        super("MyFrame" + (++id));
        setVisible(true);
        setBounds(x, y, w, h);
        setBackground(color);
    }

}
