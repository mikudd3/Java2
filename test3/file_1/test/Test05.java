package com.lanqiao.javalearn.java2.test3.file_1.test;

import java.io.File;

/**
 * 统计一个文件夹的总大小
 */
public class Test05 {
    public static void main(String[] args) {
        File file = new File("E:\\Java\\Lanqiao");
        long len = getLen(file);
        System.out.println(len);//4919189
    }

    /**
     * 统计一个文件夹的总大小
     *
     * @param src
     * @return
     */
    public static long getLen(File src) {
        //1.定义变量进行累加
        long len = 0;
        //2.进入src文件夹
        File[] files = src.listFiles();
        //3.遍历数组
        for (File file : files) {
            //4.判断
            if (file.isFile()) {
                //我们就把当前文件的大小累加到len当中
                len += file.length();
            } else {
                //判断，如果是文件夹就递归
                len += getLen(file);
            }
        }
        return len;
    }
}
