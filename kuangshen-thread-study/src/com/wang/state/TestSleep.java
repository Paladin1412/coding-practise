package com.wang.state;

/**
 * @Description:模拟网络延时 放大线程不安全性
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 09:32
 **/
public class TestSleep implements Runnable {
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();

        new Thread(ticket, "A").start();
        new Thread(ticket, "B").start();
        new Thread(ticket, "C").start();
        new Thread(ticket, "D").start();
        new Thread(ticket, "E").start();
    }
}
