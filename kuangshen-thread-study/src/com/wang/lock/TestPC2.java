package com.wang.lock;

/**
 * @Description: 测试生产者消费者问题2 信号灯法 设置标志位
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 21:43
 **/
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者 演员
class Player extends Thread {
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("节目A");
            } else {
                this.tv.play("节目B");
            }
        }
    }
}


//消费者 观众
class Watcher extends Thread {
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }

}

//产品 节目
class TV {
    String voice;
    boolean flag = true;

    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了" + voice);

        this.voice = voice;
        this.flag = !this.flag;
        this.notifyAll();
    }

    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了" + voice);
        this.flag = !this.flag;
        this.notifyAll();
    }
}