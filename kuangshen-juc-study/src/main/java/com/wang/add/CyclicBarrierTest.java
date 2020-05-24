package com.wang.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-24 12:03
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("OK");
        });
        for (int i = 0; i < 7; i++) {
            // lambda能操作到for循环的i么 不能 lambda本质是一个类 除非i设置为final或jdk8的effecitvely final
            int finalI = i; //jdk8的优化 默认应该是final int finalI = i
            new Thread(() -> {
                System.out.println(finalI);
                try {
                    cyclicBarrier.await(); //等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
