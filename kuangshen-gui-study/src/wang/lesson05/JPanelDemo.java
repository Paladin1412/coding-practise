package wang.lesson05;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Container;
import java.awt.GridLayout;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 09:27
 **/
public class JPanelDemo extends JFrame {
    public JPanelDemo() {
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2, 1, 10, 10)); //后面的参数是间距

        JPanel panel1 = new JPanel(new GridLayout(1, 3));
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        JPanel panel3 = new JPanel(new GridLayout(2, 1));
        JPanel panel4 = new JPanel(new GridLayout(3, 2));

        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel2.add(new JButton("1"));
        panel2.add(new JButton("1"));
        panel3.add(new JButton("1"));
        panel3.add(new JButton("1"));
        panel4.add(new JButton("1"));
        panel4.add(new JButton("1"));
        panel4.add(new JButton("1"));
        panel4.add(new JButton("1"));
        panel4.add(new JButton("1"));
        panel4.add(new JButton("1"));

        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        container.add(panel4);

        this.setVisible(true);
        this.setSize(200, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
