package com.wang.function;

import java.util.function.Function;

/**
 * @Description: 函数式接口 有一个输入参数 有一个输出
 * 函数式接口可以用lambda简化
 * @Author: wangyinghao_sx
 * @Date: 2020-05-25 13:04
 **/
public class Demo01 {
    public static void main(String[] args) {
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };

        function = (str) -> {
            return str;
        };
        System.out.println(function.apply("test"));
    }
}
