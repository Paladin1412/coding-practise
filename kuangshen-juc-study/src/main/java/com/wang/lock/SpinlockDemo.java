package com.wang.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 17:23
 **/
public class SpinlockDemo {

    AtomicReference atomicReference = new AtomicReference();

    // 加锁
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName());
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    // 解锁
    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName());
        atomicReference.compareAndSet(thread, null);
    }
}
