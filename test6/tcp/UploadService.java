package com.lanqiao.javalearn.java2.test6.tcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @project: 基于 TCP 协议的图片上传 服务器端
 * @author: mikudd3
 * @version: 1.0
 */
public class UploadService {
    public static void main(String[] args) {
        try {
            // 创建一个ServerSocket监听10203端口的客户端请求
            ServerSocket server = new ServerSocket(10203);
            // 使用accept()阻塞当前线程，等待客户端请求
            Socket socket = server.accept();
            // 由Socket获得输入流，并创建缓冲输入流
            BufferedInputStream netIn = new BufferedInputStream(socket.getInputStream());
            // 由文件输出流创建缓冲输出流
            OutputStream out = new FileOutputStream("src/com/lanqiao/javalearn/java2/test6/tcp/mn.jpg");
            // 准备一个缓冲区
            byte[] buffer = new byte[1024 * 34];
            int len = 0;
            while ((len = netIn.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            //给客户端发送反馈
            OutputStream netOut = socket.getOutputStream();
            netOut.write("接收完成".getBytes());

            //释放资源
            netOut.close();
            netIn.close();
            out.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

