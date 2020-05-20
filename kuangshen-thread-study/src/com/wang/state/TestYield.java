package com.wang.state;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 09:43
 **/
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread() + "线程停止执行");
    }
}
