package com.wang.unsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-24 10:34
 **/
public class SetTest {
    public static void main(String[] args) {

        //1.Set<String> set = Collections.synchronizedSet(new HashSet<>());
        //2.Set<String> set = new CopyOnWriteArraySet<>();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
