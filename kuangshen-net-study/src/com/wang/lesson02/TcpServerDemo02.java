package com.wang.lesson02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 18:18
 **/
public class TcpServerDemo02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();//阻塞式监听 会一直等待客户端连接
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = (is.read(buffer))) != -1) {
            fos.write(buffer, 0, len);
        }
        //通知客户端 服务端接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("OK".getBytes());

        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
