package com.wang.thread;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 12:04
 **/
public class DeadLock {
    public static void main(String[] args) {
        Makeup girl1 = new Makeup(0, "A");
        Makeup girl2 = new Makeup(1, "B");
        girl1.start();
        girl2.start();
    }
}

class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {

    //需要的资源只有一份 用static来保证
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        makeup();
    }

    private void makeup() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + "口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {
                    System.out.println(this.girlName + "镜子");
                }
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.girlName + "镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) {
                    System.out.println(this.girlName + "口红");
                }
            }
        }
    }
}
