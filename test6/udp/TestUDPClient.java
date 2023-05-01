package com.lanqiao.javalearn.java2.test6.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import java.net.InetAddress;

/**
 * @project: Socket 通信发送端
 * @author: mikudd3
 * @version: 1.0
 */
public class TestUDPClient {
    public static void main(String args[]) throws Exception {
        long n = 10000L;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeLong(n);
        byte[] buf = baos.toByteArray();
        System.out.println("Socket通信发送端");
        System.out.println("发送数据长度为：" + buf.length);
        //创建数据报包的套接字，端口号9999
        DatagramSocket ds = new DatagramSocket(9999);
        //创建发送的数据报包
        DatagramPacket dp = new DatagramPacket(buf, buf.length,
                InetAddress.getByName("127.0.0.1"), 8888);
        //从此套接字发送数据报包
        ds.send(dp);
        ds.close();
    }
}
