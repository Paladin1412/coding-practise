package com.wang.function;

import java.util.function.Consumer;

/**
 * @Description: 消费型接口 只有输入 没有返回值
 * @Author: wangyinghao_sx
 * @Date: 2020-05-25 13:37
 **/
public class Demo03 {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer = (s)->{
            System.out.println(s);
        };
        consumer.accept("test");
    }
}
