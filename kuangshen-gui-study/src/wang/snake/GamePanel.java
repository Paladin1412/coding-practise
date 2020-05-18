package wang.snake;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 11:46
 **/
public class GamePanel extends JPanel implements KeyListener, ActionListener {

    int length;
    int[] snakeX = new int[600]; //蛇x坐标
    int[] snakeY = new int[500];

    boolean isStart = false;

    String fx;

    Timer timer = new Timer(100, this); //100浩毫秒执行一次

    int foodX; //食物坐标
    int foodY;
    Random random = new Random();

    boolean isFail = false;

    int score;

    public GamePanel() {
        init();
        //获得焦点和键盘事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    public void init() {
        length = 3;
        snakeX[0] = 100;
        snakeY[0] = 100;
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;
        fx = "R";

        foodX = 25 + 25 * random.nextInt(34);
        foodY = 75 + 25 * random.nextInt(24);
        score = 0;
    }

    //绘制面板 游戏里的所有东西 都用这个画笔画
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //清屏

        //绘制静态面板
        this.setBackground(Color.WHITE);
        Data.header.paintIcon(this, g, 25, 11);
        g.fillRect(25, 75, 850, 600);

        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度: " + length, 750, 35);
        g.drawString("分数: " + score, 750, 50);

        Data.food.paintIcon(this, g, foodX, foodY);

        if (fx.equals("R")) {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("L")) {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("U")) {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("D")) {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }


        if (!isStart) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 300, 300);
        }

        if (isFail) {
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("失败，按下空格重新开始", 300, 300);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if (isFail) {
                isFail = false;
                init();
            } else {
                isStart = !isStart;
                repaint();
            }
            repaint();
        }
        if (keyCode == KeyEvent.VK_UP) {
            fx = "U";
        } else if (keyCode == KeyEvent.VK_DOWN) {
            fx = "D";
        } else if (keyCode == KeyEvent.VK_LEFT) {
            fx = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            fx = "R";
        } else if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    //事件监听--需要通过固定时间来刷新 1s 10次
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && !isFail) {

            //吃食物
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                length++;
                score += 10;
                foodX = 25 + 25 * random.nextInt(34);
                foodY = 75 + 25 * random.nextInt(24);
            }


            for (int i = length - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            if (fx.equals("R")) {
                snakeX[0] = snakeX[0] + 25;
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (fx.equals("L")) {
                snakeX[0] = snakeX[0] - 25;
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (fx.equals("U")) {
                snakeY[0] = snakeY[0] - 25;
                if (snakeY[0] < 75) {
                    snakeY[0] = 650;
                }
            } else if (fx.equals("D")) {
                snakeY[0] = snakeY[0] + 25;
                if (snakeY[0] > 650) {
                    snakeY[0] = 75;
                }
            }
            //失败判定 撞到自己失败
            for (int i = 1; i < length; i++) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isFail = true;
                }
            }

            repaint();
        }
        timer.start();
    }
}
