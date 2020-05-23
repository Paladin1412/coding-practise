package com.wang;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-22 23:31
 **/
public class Demo01 {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("max:" + (maxMemory/(double)1024/1024));
        System.out.println("total:" + (totalMemory/(double)1024/1024));
    }
}
