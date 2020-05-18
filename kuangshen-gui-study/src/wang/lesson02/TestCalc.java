package wang.lesson02;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 13:18
 **/
public class TestCalc {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}


// 计算器类
class Calculator extends Frame {
    TextField num1, num2, num3;

    public void loadFrame() {
        // 三个文本框
        num1 = new TextField(10); // 字符数
        num2 = new TextField(10);
        num3 = new TextField(10);
        // 一个按钮
        Button button = new Button("=");
        // 一个标签
        Label label = new Label("+");

        button.addActionListener(new MyCalculatorListener());

        setLayout(new FlowLayout());

        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        pack();
        setVisible(true);

    }
    // 监听器类
    // 内部类的最大的好处，就是可以畅通无阻的访问外部类的属性和方法
    private class MyCalculatorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // 获得两个数字
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());

            //运算后放到第三个框
            num3.setText(String.valueOf(n1 + n2));
            //清除前两个框
            num1.setText("");
            num2.setText("");
        }
    }
}

