package com.wang.add;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-24 11:58
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await(); //等待计数器归零 再向下继续执行
        System.out.println("OK");
    }
}
