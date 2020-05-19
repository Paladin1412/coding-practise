package com.wang.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 13:22
 **/
public class TalkReceive implements Runnable {

    DatagramSocket socket;
    private int port;

    public TalkReceive(int port) {
        this.port = port;
        try {
            socket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);
                byte[] data = packet.getData();
                String receiveData = new String(data, 0, packet.getLength());
                System.out.println("from " + packet.getAddress() + "," + "port " + packet.getPort() + ":" + receiveData);
                if (receiveData.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
