package wang.lesson05;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Container;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 09:51
 **/
public class JButtonDemo03 extends JFrame {
    public JButtonDemo03() {
        Container container = this.getContentPane();
        //多选框
        Checkbox checkbox1 = new Checkbox("01");
        Checkbox checkbox2 = new Checkbox("02");


        container.add(checkbox1, BorderLayout.NORTH);
        container.add(checkbox2, BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo03();
    }
}
