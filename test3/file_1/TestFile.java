package com.lanqiao.javalearn.java2.test3.file_1;

import java.io.File;
import java.io.IOException;

/**
 * @project: File 类中的方法使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestFile {
    public static void main(String[] args) {
        System.out.println("文件系统根目录");
        for (File root : File.listRoots()) {
            //format方法以格式化形式输出字符串
            System.out.format("%s", root);
        }
        System.out.println();

        try {
            showFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showFile() throws IOException {
        //创建File类对象file，注意使用转义字符 `\`
        File f = new File("E:\\Java\\Lanqiao\\src\\com\\lanqiao\\javalearn\\java2\\test3\\file");
        File f1 = new File("E:\\Java\\Lanqiao\\src\\com\\lanqiao\\javalearn\\java2\\test3\\file");

        //当不存在该文件时，创建一个新的空文件
        //f1.createNewFile();

        System.out.format("输出字符串：%s%n", f);

        System.out.format("判断File类对象是否存在：%b%n", f.exists());

        //%tc，输出日期和时间
        System.out.format("获取File类对象最后修改时间：%tc%n", f.lastModified());

        System.out.format("判断File类对象是否是文件：%b%n", f.isFile());

        System.out.format("判断File类对象是否是目录：%b%n", f.isDirectory());

        System.out.format("判断File类对象是否有隐藏的属性：%b%n", f.isHidden());

        System.out.format("判断File类对象是否可读：%b%n", f.canRead());

        System.out.format("判断File类对象是否可写：%b%n", f.canWrite());

        System.out.format("判断FIle类对象是否可执行：%b%n", f.canExecute());

        System.out.format("判断File类对象是否是绝对路径：%b%n", f.isAbsolute());

        System.out.format("获取File类对象的长度：%d%n", f.length());

        System.out.format("获取FIle类对象的名称：%s%n", f.getName());

        System.out.format("获取File类对象的路径：%s%n", f.getPath());

        System.out.format("获取File类对象的绝对路径：%s%n", f.getAbsolutePath());

        System.out.format("获取File类对象父目录的路径: %s%n", f.getParent());

    }
}
