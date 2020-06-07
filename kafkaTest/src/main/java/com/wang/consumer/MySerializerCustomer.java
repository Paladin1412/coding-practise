package com.wang.consumer;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-06 23:30
 **/
public class MySerializerCustomer {
    private int id;
    private String name;

    public MySerializerCustomer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
