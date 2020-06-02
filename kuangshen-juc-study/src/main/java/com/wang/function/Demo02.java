package com.wang.function;

import java.util.function.Predicate;

/**
 * @Description: 断定型接口 有一个输入参数 返回值只能是布尔值
 * @Author: wangyinghao_sx
 * @Date: 2020-05-25 13:13
 **/
public class Demo02 {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            //判断字符串是否为空
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        predicate = (s)->{
            return s.isEmpty();
        };
        System.out.println(predicate.test(""));
    }
}
