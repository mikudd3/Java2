package com.lanqiao.javalearn.java2.test3.io_2.chario.charstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @project: 字符流的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestCharStream {
    public static void main(String[] args) {

        FileReader in = null;
        FileWriter out = null;

        try {
            //其中args[0]代表程序执行时输入的第一个参数
            in = new FileReader(args[0]);
            out = new FileWriter(args[1]);

            //通过逐个读取、存入字符，实现文件复制

            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
