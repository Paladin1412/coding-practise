package wang.lesson04;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 22:57
 **/
public class DialogDemo extends JFrame {
    public DialogDemo() {
        this.setVisible(true);
        this.setSize(400, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        //绝对布局
        container.setLayout(null);

        JButton button = new JButton("点击弹出一个对话框");
        button.setBounds(30, 30, 200, 50);

        //点击button弹出弹窗

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDialog();
            }
        });

        container.add(button);
    }

    public static void main(String[] args) {
        new DialogDemo();
    }
}

//弹窗的窗口
class MyDialog extends JDialog {
    public MyDialog() {
        this.setVisible(true);
        this.setBounds(100, 100, 500, 500);

        Container container = this.getContentPane();
        container.setLayout(null);

        JLabel jLabel = new JLabel("弹窗");
        jLabel.setBounds(100, 100, 100, 100);
        container.add(jLabel);
    }
}