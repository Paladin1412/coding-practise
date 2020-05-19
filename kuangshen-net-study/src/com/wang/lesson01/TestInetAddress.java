package com.wang.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description: 测试IP
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 16:37
 **/
public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {

        //查询本机地址
        InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
        System.out.println(inetAddress1);
        InetAddress inetAddress2 = InetAddress.getByName("localhost");
        System.out.println(inetAddress2);
        InetAddress inetAddress3 = InetAddress.getLocalHost();
        System.out.println(inetAddress3);

        //查询网站地址
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);

        //常用方法
        System.out.println(baidu.getAddress());
        System.out.println(baidu.getCanonicalHostName());
        System.out.println(baidu.getHostAddress()); //ip
        System.out.println(baidu.getHostName()); //域名 或者本机电脑名字
    }
}
