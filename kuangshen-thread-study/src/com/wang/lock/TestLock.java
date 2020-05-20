package com.wang.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 17:30
 **/
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {
    int ticketNums = 10;

    //定义Lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            try {
                lock.lock();
                if (ticketNums > 0) {
                    System.out.println(ticketNums--);
                } else {
                    break;

                }
            } finally {
                lock.unlock();
            }
        }
    }
}
