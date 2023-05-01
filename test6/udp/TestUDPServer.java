package com.lanqiao.javalearn.java2.test6.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @project: Socket 通信接收端
 * @author: mikudd3
 * @version: 1.0
 */
public class TestUDPServer {
    public static void main(String args[]) throws Exception {
        //创建数据报包的套接字，端口号8888
        DatagramSocket ds = new DatagramSocket(8888);
        byte buf[] = new byte[1024];
        //创建接收的数据报包
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        System.out.println("Socket通信接收端");
        while (true) {
            //从此套接字接收数据报包
            ds.receive(dp);
            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            DataInputStream dis = new DataInputStream(bais);
            System.out.println("接收数据为：" + dis.readLong());
        }
    }
}
