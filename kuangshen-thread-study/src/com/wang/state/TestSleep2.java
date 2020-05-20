package com.wang.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 模拟倒计时
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 09:35
 **/
public class TestSleep2 {
    public static void main(String[] args) {
//        tenDown();
        //打印系统当前时间
        Date startTime = new Date(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //模拟倒计时
    public static void tenDown() {
        int num = 10;
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(num--);
                if (num <= 0) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
