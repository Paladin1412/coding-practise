package com.wang;

import java.util.Random;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-23 09:46
 **/
public class Demo02 {
    public static void main(String[] args) {
        String str = "testtesttesttesttesttesttesttesttesttest";
        while (true) {
            str = str + new Random().nextInt(88888888) + new Random().nextInt(99999999);
        }
    }
}
