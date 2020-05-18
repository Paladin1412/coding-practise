package wang.lesson02;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 12:46
 **/
public class TestText01 {
    public static void main(String[] args) {
        // 启动
        new MyFrame();
    }
}

class MyFrame extends Frame {
    public MyFrame() {
        TextField textField = new TextField();
        add(textField);

        // 监听文本框输入的文字
        MyTextActionListener myTextActionListener = new MyTextActionListener();
        //按下enter会触发这个输入框的事件
        textField.addActionListener(myTextActionListener);

        //设置替换编码
        textField.setEchoChar('*');

        pack();
        setVisible(true);
    }
}

class MyTextActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField textField = (TextField) e.getSource();
        String text = textField.getText();//获得输入框的文本
        System.out.println(text);
        textField.setText("");
    }
}
