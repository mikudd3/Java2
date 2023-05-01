package com.lanqiao.javalearn.java2.test3.io_2.iotask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @project: 文件加密
 * 为了保证文件的安全性，就需要对原始文件进行加密存储，再使用的时候再对其进行解密处理
 * 加密原理:
 * 对原始文件中的每一个字节数据进行更改，然后将更改以后的数据存储到新的文件中.
 * 解密原理:
 * 读取加密之后的文件，按照加密的规则反向操作，变成原始文件。
 * @author: mikudd3
 * @version: 1.0
 */
public class Test02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //要加密的文件
            fis = new FileInputStream("E:/Java/test/src/1.txt");
            //加密后的文件
            fos = new FileOutputStream("E:/Java/test/src/5.txt");
            //对数据进行加密
            int len;
            while ((len = fis.read()) != -1) {
                fos.write(len ^ 2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
