package com.wang.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 17:27
 **/
public class TestSpinLock {
    public static void main(String[] args) throws InterruptedException {

        //底层使用自旋锁CAS
        SpinlockDemo spinlockDemo = new SpinlockDemo();
        new Thread(()->{
            spinlockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinlockDemo.myUnLock();
            }
        },"T1").start();

        TimeUnit.SECONDS.sleep(1);
        //T2必须等待T1解锁之后才能解锁
        new Thread(()->{
            spinlockDemo.myLock();
            try {
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinlockDemo.myUnLock();
            }
        },"T2").start();

    }
}
