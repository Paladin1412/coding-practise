package com.wang.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-24 23:09
 **/
public class Demo01 {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newSingleThreadExecutor();//单个线程
////        ExecutorService pool = Executors.newFixedThreadPool(5); //固定线程池大小
////        ExecutorService pool = Executors.newCachedThreadPool(); //可伸缩
//
//        try {
//            for (int i = 0; i < 10; i++) {
//                pool.execute(() -> {
//                    System.out.println(Thread.currentThread().getName());
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            pool.shutdown();
//        }
        //手动创建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                5,
                3, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());//银行满了 还有人进来 不处理这个人并抛出异常
        try {
            //最大承载等于 maxPoolSize+linkedBlockingDeque.size
            for (int i = 0; i <10; i++) {
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
