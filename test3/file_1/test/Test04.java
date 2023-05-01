package com.lanqiao.javalearn.java2.test3.file_1.test;

import java.io.File;

/**
 * 删除一个多级文件夹
 * 如果我们要删除一个有内容的文件夹
 * 1.先删除文件夹里面所有的内容
 * 2.再删除自己
 */
public class Test04 {
    public static void main(String[] args) {
        File file = new File("D:\\aaa\\src");
        delete(file);
    }

    /**
     * 删除src文件夹
     *
     * @param src
     */
    public static void delete(File src) {
        //1.先删除文件夹里面所有的内容
        //进入src
        File[] files = src.listFiles();
        //遍历
        for (File file : files) {
            //判断,如果是文件，删除
            if (file.isFile()) {
                file.delete();
            } else {
                //判断,如果是文件夹，就递归
                delete(file);
            }
        }
        //2.再删除自己
        src.delete();
    }
}
