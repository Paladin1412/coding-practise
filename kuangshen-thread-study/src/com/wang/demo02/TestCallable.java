package com.wang.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description: Callable好处 有返回值 可以抛出异常
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 22:07
 **/
public class TestCallable implements Callable<Boolean> {

    public String url;
    public String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader2 webDownloader = new WebDownloader2();
        webDownloader.downloader(url, name);
        System.out.println("下载的文件名为" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testCallable1 = new TestCallable("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u" +
                "=2534506313,1688529724&fm=26&gp=0" +
                ".jpg", "1.jpg");
        TestCallable testCallable2 = new TestCallable("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u" +
                "=2534506313,1688529724&fm=26&gp=0" +
                ".jpg", "2.jpg");
        TestCallable testCallable3 = new TestCallable("https://ss3.bdstatic" +
                ".com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2534506313,1688529724&fm=26&gp=0" +
                ".jpg", "3.jpg");
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(testCallable1);
        Future<Boolean> r2 = ser.submit(testCallable2);
        Future<Boolean> r3 = ser.submit(testCallable3);

        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        ser.shutdownNow();
    }
}

class WebDownloader2 {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader方法异常");
        }
    }
}