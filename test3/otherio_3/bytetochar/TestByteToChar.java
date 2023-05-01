package com.lanqiao.javalearn.java2.test3.otherio_3.bytetochar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @project: 将字节流转换为字符流
 * @author: mikudd3
 * @version: 1.0
 */
public class TestByteToChar {
    public static void main(String[] args) {
        BufferedReader in = null;
        try {
            //将字节流System.in通过InputStreamReader转换成字符流
            in = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("请输入你今天最想说的话：");
            String s = in.readLine();

            System.out.println("你最想表达的是：" + s);
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
        }
    }

}
