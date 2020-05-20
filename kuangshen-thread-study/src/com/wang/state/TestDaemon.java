package com.wang.state;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 10:35
 **/
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认是false 表示用户线程

        thread.start();
        new Thread(you).start(); //用户线程
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("God bless u");
        }
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("活着");
        }
        System.out.println("====goodbye======");
    }
}
