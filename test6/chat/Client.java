package com.lanqiao.javalearn.java2.test6.chat;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 * @project: 模拟聊天室客户端
 * @author: mikudd3
 * @version: 1.0
 */
public class Client implements Runnable {
    static int i = 0;
    private String name;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new Thread(new Client()).start();
    }

    @Override
    public void run() {
        name = "client" + new Random().nextInt(100);
        OutputStream os = null;
        DataOutputStream dos = null;

        try {
            Socket socket = new Socket("localhost", 8888);
            System.out.println("已经连上服务端");
            while (true) {
                os = socket.getOutputStream();
                dos = new DataOutputStream(os);
                //向服务端发送信息
                dos.writeUTF("第" + (++i) + "个客户已连接");
                String msg = input.next();
                System.out.println(name + "说：" + msg);
                dos.writeUTF(name + "说:" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
