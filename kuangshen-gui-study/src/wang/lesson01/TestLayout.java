package wang.lesson01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 12:03
 **/
public class TestLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.setBounds(100, 100, 200, 200);
        frame.setBackground(Color.WHITE);
        frame.setLayout(new GridLayout(2, 1));

        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2, 1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2, 2));

        p1.add(new Button("East-1"), BorderLayout.EAST);
        p1.add(new Button("West-1"), BorderLayout.WEST);

        p2.add(new Button("p2-1"));
        p2.add(new Button("p2-2"));

        p1.add(p2, BorderLayout.CENTER);

        p3.add(new Button("East-2"), BorderLayout.EAST);
        p3.add(new Button("West-2"), BorderLayout.WEST);

        for (int i = 0; i < 4; i++) {
            p4.add(new Button("p4-" + i + 1));
        }
        p3.add(p4, BorderLayout.CENTER);

        frame.add(p1);
        frame.add(p3);

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
