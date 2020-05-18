package wang.lesson06;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.WindowConstants;
import java.awt.Container;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 11:01
 **/
public class TestComboboxDemo02 extends JFrame {
    public TestComboboxDemo02() {

        Container container = this.getContentPane();

        //生成列表的内容
        String[] contents = {"1", "2", "3", "4"};
        //列表中需要放入内容
        JList jList = new JList(contents);
        container.add(jList);


        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboboxDemo02();
    }
}
