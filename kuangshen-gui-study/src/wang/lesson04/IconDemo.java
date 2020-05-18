package wang.lesson04;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 23:12
 **/
public class IconDemo extends JFrame implements Icon {

    private int width;
    private int height;

    public IconDemo() {
    }

    public IconDemo(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init() {
        IconDemo iconDemo = new IconDemo(15, 15);
        JLabel label = new JLabel("icontest", iconDemo, SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    public static void main(String[] args) {
        new IconDemo().init();
    }
}
