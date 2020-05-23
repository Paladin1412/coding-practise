package com.wang.demo01;

/**
 * @Description: 基本的卖票例子
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 17:00
 **/

/**
 * 线程就是一个单独的资源类，没有任何附属的操作
 * 1、 属性 方法
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        //并发 多线程操作同一个资源类
        Ticket02 ticket = new Ticket02();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();
    }
}

//资源OOP
class Ticket {
    //属性 方法
    private int number = 50;

    //卖票的方式
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "票");
        }
    }
}
