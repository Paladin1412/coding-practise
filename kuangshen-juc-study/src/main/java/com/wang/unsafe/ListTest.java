package com.wang.unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description: java.util.ConcurrentModificationException
 * @Author: wangyinghao_sx
 * @Date: 2020-05-24 10:17
 **/
public class ListTest {
    public static void main(String[] args) {
        /**
         * 并发下ArrayList不安全
         * 解决方案：
         * 1.List<String> list = new Vector<>();
         * 2.List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3.List<String> list = new CopyOnWriteArrayList<>();
         */

        //CopyOnWrite 写入时复制 COW 计算机程序设计领域的一种优化策略
//        List<String> list = new CopyOnWriteArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
