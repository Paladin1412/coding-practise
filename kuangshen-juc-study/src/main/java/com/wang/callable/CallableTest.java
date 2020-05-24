package com.wang.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-24 11:38
 **/
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new Thread(new MyThread()).start();

        MyCallable callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start(); //两个Thread只返回了一个123  结果有缓存 效率高
        String o = (String) futureTask.get(); //获取Callable的返回结果 get可能产生阻塞
        //把get放到最后 或者异步通信
        System.out.println(o);
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {

    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "123";
    }
}
