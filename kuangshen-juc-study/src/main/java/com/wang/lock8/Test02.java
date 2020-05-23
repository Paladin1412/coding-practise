package com.wang.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 8锁 就是关于锁的八个问题
 * 3. 增加一个普通方法 先hello 再发短信
 * 4. 两个对象 两个同步方法 先打电话 再发短信 （发短信的sleep了）
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 20:48
 **/
public class Test02 {
    public static void main(String[] args) {
        Phone02 phone1 = new Phone02();
        Phone02 phone2 = new Phone02();

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

class Phone02 {
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

    public void hello(){
        System.out.println("hello");
    }

}