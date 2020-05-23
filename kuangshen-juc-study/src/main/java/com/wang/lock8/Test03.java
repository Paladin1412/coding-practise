package com.wang.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 8锁 就是关于锁的八个问题
 * 5. 增加两个静态的同步方法 只有一个对象 先打印发短信 后打电话
 * 6. 两个对象,增加两个静态的同步方法 先发短信 后打电话
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 20:48
 **/
public class Test03 {
    public static void main(String[] args) {
        Phone03 phone1 = new Phone03();
        Phone03 phone2 = new Phone03();

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

class Phone03 {
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

    public static synchronized void call() {
        System.out.println("打电话");
    }
}

