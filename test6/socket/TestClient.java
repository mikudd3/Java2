package com.lanqiao.javalearn.java2.test6.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

/**
 * @project: 客户端
 * @author: mikudd3
 * @version: 1.0
 */
public class TestClient {
    public static void main(String[] args) {
        try {
            // 通过IP地址和端口号，创建一个Socket对象
            Socket s = new Socket("127.0.0.1", 8888);
            // 建立输入数据流
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());
            // 关闭数据流对象
            dis.close();
            // 关闭 Socket 对象
            s.close();
        } catch (ConnectException e) {
            e.printStackTrace();
            System.err.println("服务器连接失败！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
