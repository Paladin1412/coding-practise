package com.wang.single;

/**
 * @Description: 静态内部类
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 13:58
 **/
public class Holder {
    private Holder() {
    }

    public static Holder getInstance() {
        return InnerClass.HOLDER;
    }

    public static class InnerClass {
        private static final Holder HOLDER = new Holder();
    }
}
