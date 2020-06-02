package com.wang.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 17:50
 **/
public class Test {
    public static void main(String[] args) {
        String A ="A";
        String B = "B";
        new Thread(new MyThread(A,B)).start();
        new Thread(new MyThread(B,A)).start();
    }

}
class MyThread implements Runnable{
    public String A;
    public String B;

    public MyThread(String a, String b) {
        A = a;
        B = b;
    }

    @Override
    public void run() {
        synchronized (A){
            System.out.println(A);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (B){
                System.out.println(B);
            }

        }
    }
}
