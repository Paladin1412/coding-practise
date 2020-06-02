package com.wang.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 12:11
 **/
public class VDemo02 {

    //AtomicInteger 原子类
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add() {
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();

        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("OK" + num);
    }
}
