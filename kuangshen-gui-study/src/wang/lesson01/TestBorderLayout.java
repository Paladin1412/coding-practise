package wang.lesson01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 11:48
 **/
public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button east = new Button("East");
        Button west = new Button("West");
        Button south = new Button("South");
        Button north = new Button("North");
        Button center = new Button("Center");

        frame.add(east,BorderLayout.EAST);
        frame.add(west,BorderLayout.WEST);
        frame.add(south,BorderLayout.SOUTH);
        frame.add(north,BorderLayout.NORTH);
        frame.add(center,BorderLayout.CENTER);

        frame.setSize(200,200);

        frame.setVisible(true);
    }
}
