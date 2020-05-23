package com.wang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 自定义注解
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 10:19
 **/
public class Test03 {
    //注解可以显式赋值 没默认值的时候必须显式赋值
    @MyAnnotation02(name = "XXX", schools = {"DUT","USTC"})
    public void test() {

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation02 {
    //注解的参数 参数类型+参数名();
    String name() default "";

    int age() default 0;

    int id() default -1;//如果默认值为-1 代表不存在

    String[] schools() default "家里蹲";
}
