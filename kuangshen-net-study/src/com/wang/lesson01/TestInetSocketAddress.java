package com.wang.lesson01;

import java.net.InetSocketAddress;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 16:51
 **/
public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(socketAddress);
        socketAddress.getAddress();
    }
}
