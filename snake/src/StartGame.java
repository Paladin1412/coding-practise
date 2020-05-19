import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 11:41
 **/
public class StartGame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        jFrame.setBounds(10, 10, 900, 720);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //游戏界面都应该在游戏面板上
        GamePanel gamePanel = new GamePanel();
        jFrame.add(gamePanel);

        jFrame.setVisible(true);
    }
}
