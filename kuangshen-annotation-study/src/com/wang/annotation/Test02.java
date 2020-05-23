package com.wang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 测试元注解
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 09:43
 **/
@MyAnnotation
public class Test02 {

    @MyAnnotation
    public void test() {

    }
}

//定义一个注解
//Target表示注解用在什么地方
@Target(value = {ElementType.METHOD, ElementType.TYPE})
//Retention表示注解在什么是你有效 SOURCE<CLASS<RUNTIME
@Retention(value = RetentionPolicy.RUNTIME)
//Document表示是否将注解生成在Javadoc中
@Documented
//Inherited可以被子类继承
@Inherited
@interface MyAnnotation {

}
