package com.wang.volatileTest;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 10:09
 **/
public class JMMDemo {
//    private static int num = 0;
    private static volatile int num = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
        System.out.println(num);
    }
}
