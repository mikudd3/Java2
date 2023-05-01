package com.lanqiao.javalearn.java2.test6.udp.task;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @project: 基于 UDP 协议文件上传
 * @author: mikudd3
 * @version: 1.0
 */
public class Service {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(8888);
            //创建图片文件
            File newFile = new File("src/com/lanqiao/javalearn/java2/test6/udp/task/data/2.jpg");
            //创建字节数组存放数据
            byte[] bytes = new byte[59134];
            //创建文件输出流写数据到数据包中
            FileOutputStream fos = new FileOutputStream(newFile);
            //创建数据包用于接收数据
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            while (true) {
                ds.receive(dp);
                //向文件中写入数据
                fos.write(dp.getData(), 0, dp.getLength());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
