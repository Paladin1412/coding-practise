package com.wang.chat;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 13:42
 **/
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend("localhost", 9999, 7777)).start();
        new Thread(new TalkReceive(8888)).start();
    }
}
