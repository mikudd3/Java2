package com.lanqiao.javalearn.java2.test3.otherio_3.buffer;

import java.io.*;

/**
 * @project: 缓冲流的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestBufferStream {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedReader(new FileReader("com/lanqiao/javalearn/java2/test3/other/ori_file.txt"));
            out = new BufferedWriter(new FileWriter("com/lanqiao/javalearn/java2/test3/other/new_file.txt"));

            //逐行读取、存入字符串，实现文件复制
            String s;
            while ((s = in.readLine()) != null) {
                out.write(s);
                //写入一个分行符，否则内容在一行显示
                out.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //流资源释放
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
