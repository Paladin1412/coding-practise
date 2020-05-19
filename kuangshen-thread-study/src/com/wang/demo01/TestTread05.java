package com.wang.demo01;

/**
 * @Description: 多个线程同时操作同一对象 买火车票的例子
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 15:48
 **/
//发现问题 多个线程操作同一个资源的时候 线程不安全 数据紊乱
public class TestTread05 implements Runnable {
    private int ticketNums = 1000;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestTread05 ticket = new TestTread05();

        new Thread(ticket,"A").start();
        new Thread(ticket,"B").start();
        new Thread(ticket,"C").start();
        new Thread(ticket,"D").start();
        new Thread(ticket,"E").start();
    }
}
