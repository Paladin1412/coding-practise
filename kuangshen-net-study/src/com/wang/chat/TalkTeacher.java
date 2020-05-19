package com.wang.chat;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 13:42
 **/
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend("localhost", 8888, 5555)).start();
        new Thread(new TalkReceive(9999)).start();
    }
}
