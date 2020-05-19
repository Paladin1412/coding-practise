package com.wang.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Description: 练习Thread 实现多线程同步下载图片
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 15:01
 **/
public class TestThread2 extends Thread {
    public String url;
    public String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载的文件名为" + name);
    }

    public static void main(String[] args) {
        TestThread2 testThread1 = new TestThread2("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2534506313,1688529724&fm=26&gp=0" +
                ".jpg", "1.jpg");
        TestThread2 testThread2 = new TestThread2("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u" +
                "=2534506313,1688529724&fm=26&gp=0" +
                ".jpg", "2.jpg");
        TestThread2 testThread3 = new TestThread2("https://ss3.bdstatic" +
                ".com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2534506313,1688529724&fm=26&gp=0" +
                ".jpg", "3.jpg");

        testThread1.start();
        testThread2.start();
        testThread3.start();
    }
}

class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader方法异常");
        }
    }
}
