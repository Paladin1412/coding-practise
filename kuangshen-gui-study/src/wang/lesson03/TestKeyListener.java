package wang.lesson03;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 22:29
 **/
public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();
    }
}

class KeyFrame extends Frame {
    public KeyFrame() {
        setBounds(100,100,300,300);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获得键盘按下的键是哪一个
                int keyCode = e.getKeyCode();
                if(keyCode==KeyEvent.VK_UP){
                    System.out.println("上");
                }
            }
        });
    }
}
