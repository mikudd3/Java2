package com.lanqiao.javalearn.java2.test6.tcp;

import java.io.*;
import java.net.Socket;


/**
 * @project: 基于 TCP 协议的图片上传 客户端
 * @author: mikudd3
 * @version: 1.0
 */
public class UploadClient {
    public static void main(String[] args) {
        try {
            // 向本机的10203端口发出请求
            Socket socket = new Socket("localHost", 10203);
            // 由Socket获得输出流，并创建缓冲输出流
            BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
            // 创建文件输入流
            InputStream fin = new FileInputStream("src/com/lanqiao/javalearn/java2/test6/tcp/timg.jpg");
            // 由文件输入流创建缓冲输入流
            BufferedInputStream in = new BufferedInputStream(fin);
            // 准备一个缓冲区
            byte[] buffer = new byte[1024 * 34];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.write("上传成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}