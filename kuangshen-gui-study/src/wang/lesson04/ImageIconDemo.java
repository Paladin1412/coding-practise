package wang.lesson04;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Container;
import java.net.URL;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 23:20
 **/
public class ImageIconDemo extends JFrame {
    public ImageIconDemo() {
        //获取图片地址
        JLabel label = new JLabel("ImageIcon");
        URL url = ImageIconDemo.class.getResource("tx.jpg");

        ImageIcon imageIcon = new ImageIcon(url);
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageIconDemo();
    }
}
