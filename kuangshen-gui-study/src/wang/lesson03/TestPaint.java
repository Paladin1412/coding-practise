package wang.lesson03;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 21:21
 **/
public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame {
    public void loadFrame() {
        setBounds(100, 100, 400, 300);
        setVisible(true);
    }

    //画笔
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(100,100,100,100);

        //养成习惯 画笔用完 还原到最初的颜色
        g.setColor(Color.BLACK);
    }
}
