package com.wang.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 8锁 就是关于锁的八个问题
 * 1. 标准情况下 先发短信 后打电话
 * 2. sendSms延迟四秒 先发短信 后打电话
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 20:48
 **/
public class Test01 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.call();
        }, "B").start();
    }
}

class Phone {
    //synchronized锁的对象是方法的调用者
    //两个方法用的是同个锁 谁先拿到谁先执行
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}
