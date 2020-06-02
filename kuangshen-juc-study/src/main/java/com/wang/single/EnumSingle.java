package com.wang.single;

/**
 * @Description: enum是什么 本身也是一个Class
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 15:03
 **/
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}

class Test{

    public static void main(String[] args) {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        EnumSingle instance2 = EnumSingle.INSTANCE;
    }
}
