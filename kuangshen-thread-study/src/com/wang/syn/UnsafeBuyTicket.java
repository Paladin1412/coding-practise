package com.wang.syn;

/**
 * @Description: 线程不安全
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 11:15
 **/
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new Thread(station, "A").start();
        new Thread(station, "B").start();
        new Thread(station, "C").start();
    }
}

class BuyTicket implements Runnable {
    int ticketNames = 100;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {
        if (ticketNames <= 0) {
            flag = false;
            return;
        }

//        //模拟延时
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNames--);
    }
}
