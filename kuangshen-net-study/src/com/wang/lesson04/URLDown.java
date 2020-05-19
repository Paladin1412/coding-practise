package com.wang.lesson04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 14:12
 **/
public class URLDown {
    public static void main(String[] args) throws IOException {
        URL url = new URL("xxxxxxxx");

        //连接到这个资源HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("xxxxxxxx");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
