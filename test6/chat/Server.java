package com.lanqiao.javalearn.java2.test6.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @project: 模拟聊天室服务端
 * @author: mikudd3
 * @version: 1.0
 */
public class Server implements Runnable {// 服务端
    Socket socket;

    public Server(Socket socket) {// 构造方法
        this.socket = socket;
    }

    public static void main(String[] args) {
        System.out.println("************服务端************");

        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new Server(socket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        // 重写run方法
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            DataInputStream dis = new DataInputStream(in);
            DataOutputStream dos = new DataOutputStream(out);
            String str = null;


            while ((str = dis.readUTF()) != null) {
                System.out.println(str);
            }
            in.close();
            out.close();
            dis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}