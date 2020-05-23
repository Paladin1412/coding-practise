package com.wang.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 8锁 就是关于锁的八个问题
 * 5. 一个普通同步方法 一个静态同步方法 只有一个对象 先打印打电话 后发短信
 * 6. 两个对象,一个普通同步方法 一个静态同步方法 先打印打电话 后发短信
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 20:48
 **/
public class Test04 {
    public static void main(String[] args) {
        Phone04 phone1 = new Phone04();
        Phone04 phone2 = new Phone04();

        new Thread(() -> {
            phone1.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.call();
        }, "B").start();
    }
}

class Phone04 {
    //synchronized锁的对象是方法的调用者
    //static 静态方法
    //类一加载就有了 锁的是Class模版
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    //普通同步方法 锁的是调用者
    public synchronized void call() {
        System.out.println("打电话");
    }
}