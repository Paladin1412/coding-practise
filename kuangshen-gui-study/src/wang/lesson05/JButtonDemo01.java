package wang.lesson05;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Container;
import java.net.URL;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 09:51
 **/
public class JButtonDemo01 extends JFrame {
    public JButtonDemo01() {
        Container container = this.getContentPane();
        URL url = JButtonDemo01.class.getResource("tx.jpg");
        Icon icon = new ImageIcon(url);

        //把图标放到按钮上
        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("图片按钮");

        container.add(button);

        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
