package com.wang.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-24 11:15
 **/
public class MapTest {
    public static void main(String[] args) {
//         Map<String, String> map = new ConcurrentHashMap<>();
        Map<String, String> map = new HashMap<>();
        // 加载因子 static final float DEFAULT_LOAD_FACTOR = 0.75f;
        // 初始化容量 static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
