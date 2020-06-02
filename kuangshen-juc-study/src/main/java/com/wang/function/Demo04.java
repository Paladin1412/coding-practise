package com.wang.function;

import java.util.function.Supplier;

/**
 * @Description: 供给型接口 没有参数输入 只有返回值
 * @Author: wangyinghao_sx
 * @Date: 2020-05-25 13:41
 **/
public class Demo04 {
    public static void main(String[] args) {
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1024;
            }
        };
        supplier = () -> {
            return 1024;
        };

        System.out.println(supplier.get());
    }
}
