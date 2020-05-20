package com.wang.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description: 测试JUC安全类型的集合
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 11:56
 **/
public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
