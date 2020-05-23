package com.wang;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 10:09
 **/
public class Demo03 {
    byte[] array = new byte[1024 * 1024];

    public static void main(String[] args) {
        int count = 0;
        ArrayList<Demo03> list = new ArrayList<>();

        try {
            while (true) {
                list.add(new Demo03());
                count++;
            }
        } catch (OutOfMemoryError e) {
            System.out.println(count);
        }
    }
}
