package wang.lesson05;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Container;
import java.net.URL;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 09:51
 **/
public class JButtonDemo02 extends JFrame {
    public JButtonDemo02() {
        Container container = this.getContentPane();
        //单选框
        JRadioButton jRadioButton1 = new JRadioButton("01");
        JRadioButton jRadioButton2 = new JRadioButton("02");
        JRadioButton jRadioButton3 = new JRadioButton("03");

        //由于单选框只能选择一个，分组 一个组中只能选一个
        ButtonGroup buttonGroup = new ButtonGroup();

        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);

        container.add(jRadioButton1, BorderLayout.CENTER);
        container.add(jRadioButton2, BorderLayout.NORTH);
        container.add(jRadioButton3, BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
