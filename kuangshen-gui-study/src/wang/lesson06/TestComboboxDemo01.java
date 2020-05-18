package wang.lesson06;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Container;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 11:01
 **/
public class TestComboboxDemo01 extends JFrame {
    public TestComboboxDemo01() {

        Container container = this.getContentPane();
        JComboBox status = new JComboBox();
        status.addItem(null);
        status.addItem("正在上映");
        status.addItem("热映");

        container.add(status);
        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboboxDemo01();
    }
}
