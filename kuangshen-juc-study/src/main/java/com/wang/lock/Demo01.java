package com.wang.lock;

/**
 * @Description: A执行完sms发完短信之后 正常来说在进入call的时候应该释放并重新获取锁 但由于可重入锁 并没有重新获取锁 所以B永远都是在A执行完sms和call之后执行
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 17:12
 **/
public class Demo01 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.sms();
        },"A").start();

        new Thread(()->{
            phone.sms();
        },"B").start();
    }
}

class Phone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+"sms");
        call();
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"call");
    }
}
