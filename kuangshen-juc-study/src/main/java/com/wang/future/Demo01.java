package com.wang.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description: 异步调用
 * @Author: wangyinghao_sx
 * @Date: 2020-05-25 15:45
 **/
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //无返回值
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
        });
        completableFuture1.get();

        //有返回值
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            return 1024;
        });

        System.out.println(completableFuture2.whenComplete((t,u)->{
            System.out.println(t); //正常的返回结果
            System.out.println(u); //错误信息
        }).exceptionally((e)->{
            System.out.println(e.getMessage());
            return 233;
        }).get());
    }
}
