package com.wang.lesson03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description: 不需要连接服务器
 * @Author: wangyinghao_sx
 * @Date: 2020-05-18 23:01
 **/
public class UdpClientDemo01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String msg = "你好";

        InetAddress host = InetAddress.getByName("localhost");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, host, port);
        socket.send(packet);
        socket.close();

    }
}
