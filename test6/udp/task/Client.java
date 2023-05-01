package com.lanqiao.javalearn.java2.test6.udp.task;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @project: 基于 UDP 协议文件上传
 * @author: mikudd3
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        //创建数据报包的套接字，端口号10203
        try {
            DatagramSocket ds = new DatagramSocket(9999);
            //创建字符数组用于存储所读取文件内容
            byte[] bytes = new byte[59134];
            //创建文件输入流读取文件
            InputStream fds = new FileInputStream("src/com/lanqiao/javalearn/java2/test6/udp/task/2.jpg");
            DatagramPacket dp;
            int len = 0;
            while ((len = fds.read(bytes)) != -1) {
                //创建数据包用于发送套接字
                dp = new DatagramPacket(bytes, len, InetAddress.getByName("127.0.0.1"), 8888);
                // 将打包的数据发送到服务端
                ds.send(dp);
            }
//            dp = new DatagramPacket("上传成功".getBytes(), "上传成功".getBytes().length,InetAddress.getByName("127.0.0.1"), 8888);
//            ds.send(dp);

            //资源释放
            ds.close();
            fds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
