package com.wang.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 15:21
 **/
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2000);

        new AtomicStampedReference(100,1);

        //public final boolean compareAndSet(int expect, int update)
        //期望 更新
        //如果期望的值达到了 就更新 否则不更新 CAS是CPU的并发原语
        atomicInteger.compareAndSet(2000,2021);
        System.out.println(atomicInteger.get());
    }
}
