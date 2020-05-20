package com.wang.state;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 09:50
 **/
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了 " + i);
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            if(i==200){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main " + i);
        }
    }
}
