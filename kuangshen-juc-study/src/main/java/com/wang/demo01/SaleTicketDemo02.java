package com.wang.demo01;

/**
 * @Description: 基本的卖票例子
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 17:00
 **/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程就是一个单独的资源类，没有任何附属的操作
 * 1、 属性 方法
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        //并发 多线程操作同一个资源类
        Ticket02 ticket = new Ticket02();

        new Thread(() -> { for (int i = 0; i < 60; i++) ticket.sale(); }, "A").start();
        new Thread(() -> { for (int i = 0; i < 60; i++) ticket.sale(); }, "B").start();
        new Thread(() -> { for (int i = 0; i < 60; i++) ticket.sale(); }, "C").start();
    }
}
//Lock三部曲
//new ReentrantLock()
//lock.lock()
//try catch finally => lock.unlock
//资源OOP
class Ticket02 {
    //属性 方法
    private int number = 50;

    Lock lock = new ReentrantLock();

    //卖票的方式
    public void sale() {

        lock.lock();

        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
