package com.lanqiao.javalearn.java2.test3.file_1;

import java.io.File;

/**
 * @project: 获取 windows 下的分隔符
 * @author: mikudd3
 * @version: 1.0
 */
public class TestFileSeparator {
    public static void main(String[] args) {
        System.out.println("PATH分隔符：" + File.pathSeparator);

        System.out.println("路径层级分隔符：" + File.separator);
    }
}
