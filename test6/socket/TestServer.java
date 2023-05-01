package com.lanqiao.javalearn.java2.test6.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @project: 服务器端
 * @author: mikudd3
 * @version: 1.0
 */
public class TestServer {
    public static void main(String[] args) {
        ServerSocket server = null;

        try {
            //创建一个ServerSocket对象，并指定端口号为8888
            server = new ServerSocket(8888);
            // 侦听并接受到此套接字的连接
            while (true) {
                Socket s = server.accept();
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF("客户端IP：" + s.getInetAddress().getHostAddress() + "客户端端口号：" + s.getPort());
                // 关闭数据流对象
                dos.close();
                // 关闭 Socket 对象
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    // 关闭 ServerSocket 对象
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
