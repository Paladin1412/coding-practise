package com.wang.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 17:12
 **/
public class Demo02 {
    public static void main(String[] args) {
        Phone1 phone = new Phone1();

        new Thread(()->{
            phone.sms();
        },"A").start();

        new Thread(()->{
            phone.sms();
        },"B").start();
    }
}

class Phone1{
    Lock lock = new ReentrantLock();
    public void sms(){
        lock.lock();  //细节问题：sms的两个锁配对 lock1->lock2->lock2.unlock->lock1.unlock
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"sms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();//锁数目需要配对
        }
        call();
    }

    public void call(){

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
