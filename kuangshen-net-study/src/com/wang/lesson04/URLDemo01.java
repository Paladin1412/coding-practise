package com.wang.lesson04;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 14:06
 **/
public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/helloworld/index.jsp?username=xxxx");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getQuery());
    }
}
