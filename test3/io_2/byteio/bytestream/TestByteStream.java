package com.lanqiao.javalearn.java2.test3.io_2.byteio.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @project: 字节流的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestByteStream {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            File f = new File("src\\com\\lanqiao\\javalearn\\java2\\test3\\bytestream\\new_file.txt");
            f.createNewFile();
            //通过构造方法之一：String构造输入流
            in = new FileInputStream("src\\com\\lanqiao\\javalearn\\java2\\test3\\bytestream\\ori_file.txt");

            //通过构造方法之一：File类构造输出流
            out = new FileOutputStream(f);

            //通过逐个读取，存入字节，实现文件复制
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
