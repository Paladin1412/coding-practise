package com.wang.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 线程不安全的集合
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 11:32
 **/
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            synchronized (list){
                new Thread(() -> {
                    list.add(Thread.currentThread().getName());
                }).start();
            }
        }
        System.out.println(list.size());
    }
}
