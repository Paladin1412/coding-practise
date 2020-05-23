package com.wang.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 线程之间的通信问题 生产者和消费者问题
 * 线程交替执行 A B操作同一个变量 num=0
 * A num+1
 * B num-1
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 17:46
 **/
public class C {
    public static void main(String[] args) {
        Data03 data = new Data03();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.printB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                data.printC();
            }
        }, "C").start();
    }
}

// 判断等待 业务 通知
class Data03 {
    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA() {
        try {
            lock.lock();
            while (number != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName());
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        try {
            lock.lock();
            while (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName());
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC() {
        try {
            lock.lock();
            while (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName());
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
