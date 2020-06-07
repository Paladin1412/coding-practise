package com.wang.pojo;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-07 13:18
 **/
public class Hello {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
