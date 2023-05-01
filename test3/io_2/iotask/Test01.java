package com.lanqiao.javalearn.java2.test3.io_2.iotask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @project: 拷贝一个文件夹，考虑子文件夹
 * @author: mikudd3
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        //要复制的文件
        File src = new File("E:/Java/test/src");
        //复制后的文件
        File dest = new File("E:/Java/test/dest");
        try {
            copyDir(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyDir(File src, File dest) throws IOException {
        //如果文件不存在，则创建文件
        dest.mkdir();
        //获取要复制的目录的数据数组
        File[] files = src.listFiles();
        for (File file : files) {
            //如果是文件
            if (file.isFile()) {
                //判断文件。拷贝
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                //字节数组
                byte[] bytes = new byte[1024];
                int len;
                while ((len = fis.read(bytes)) != -1) {
                    //写入文件
                    fos.write(bytes, 0, len);
                }

                //关闭资源
                fos.close();
                fis.close();
            } else {
                // 如果是文件夹，则递归调用
                copyDir(file, new File(dest, file.getName()));
            }
        }
    }
}
