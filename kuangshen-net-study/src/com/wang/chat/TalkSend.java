package com.wang.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 13:14
 **/
public class TalkSend implements Runnable {
    DatagramSocket socket;
    BufferedReader reader;
    private String toIP;
    private int toPort;
    private int fromPort;

    public TalkSend(String toIP, int toPort, int fromPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        this.fromPort = fromPort;

        try {
            socket = new DatagramSocket(this.fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            //准备数据 控制台读取
            String data = null;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(toIP, toPort));
                socket.send(packet);
                if (data.equals("bye")) {
                    socket.close();
                    System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
