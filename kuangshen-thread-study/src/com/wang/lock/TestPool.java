package com.wang.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 22:26
 **/
public class TestPool {
    public static void main(String[] args) {
        //创建服务 创建线程池
        //newFixedThreadPool参数为线程池大小
        ExecutorService service = Executors.newFixedThreadPool(10);

        //执行
        service.submit(new MyThread());
        service.submit(new MyThread());
        service.submit(new MyThread());
        service.submit(new MyThread());
        service.submit(new MyThread());

        //关闭连接
        service.shutdown();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
