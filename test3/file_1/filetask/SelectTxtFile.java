package com.lanqiao.javalearn.java2.test3.file_1.filetask;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @project: 查找指定目录下的文本文件
 * @author: mikudd3
 * @version: 1.0
 */
public class SelectTxtFile {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("请输入读取路径：");
        //输入路径
        String pathname = input.next();
        File f = new File(pathname);

        //判断文件是否存在
        if (!f.exists() && !f.isDirectory()) {
            System.out.println("该目录不存在，或者它不是个目录");
        }
        //使用匿名内部类创建过滤器，过滤出.txt结尾的文件
        File[] fileList = f.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".txt"))
                    return true;
                return false;
            }
        });
        try {
            for (File f1 : fileList) {
                System.out.println(f1.getName());
            }
        } catch (NullPointerException e) {
            e.getMessage();
        } finally {
            input.close();
        }
    }
}
