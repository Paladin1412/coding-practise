package com.wang.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 18:14
 **/
public class TcpClientDemo02 {
    public static void main(String[] args) throws IOException {
        //创建Socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //创建一个输出流
        OutputStream os = socket.getOutputStream();

        FileInputStream fis = new FileInputStream("tx.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        //通知服务器 我传输完了
        socket.shutdownOutput();
        //确定服务器接受完毕 才断开连接
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        if ("OK".equals(baos.toString())) {
            baos.close();
            is.close();
            fis.close();
            os.close();
            socket.close();
        }
    }
}
