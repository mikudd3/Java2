package com.lanqiao.javalearn.java2.test3.io_2.iotask;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @project: 文本文件中有以下的数据：
 * 1-3-5-7-9-2-4-3-0
 * 将文件中的数据进行排序，变成以下的数据：
 * 0-1-2-3-3-4-5-7-9
 * @author: mikudd3
 * @version: 1.0
 */
public class Test03 {
    public static void main(String[] args) {
//        fileSort1();
        fileSort2();
    }

    /**
     * 方法一
     */
    public static void fileSort1() {
        //字节流
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 创建读取对象
            fr = new FileReader("src/com/lanqiao/javalearn/java2/test3/iotask/a.txt");
            //字符串
            String s = "";
            //循环读取数据
            int ch;
            while ((ch = fr.read()) != -1) {
                s += (char) (ch);
            }
            //将字符串进行分割
            String[] strArr = s.split("-");
            //将数据加入集合
            List<Integer> list = new ArrayList<>();
            for (String s1 : strArr) {
                list.add(Integer.parseInt(s1));
            }
            //排序
            Collections.sort(list);

//            System.out.println(list);

            //写入文件
            fw = new FileWriter("src/com/lanqiao/javalearn/java2/test3/iotask/a.txt");
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    fw.write(list.get(i) + "");
                } else {
                    fw.write(list.get(i) + "-");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 方法二
     */
    public static void fileSort2() {
        //字节流
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 创建读取对象
            fr = new FileReader("src/com/lanqiao/javalearn/java2/test3/iotask/a.txt");
            //字符串
            String s = "";
            //循环读取数据
            int ch;
            while ((ch = fr.read()) != -1) {
                s += (char) (ch);
            }
            //使用链式编程转为integer数组
            Integer[] arr = Arrays.stream(s
                            .split("-"))
                    .map(Integer::parseInt)
                    .sorted()
                    .toArray(Integer[]::new);

            fw = new FileWriter("src/com/lanqiao/javalearn/java2/test3/iotask/a.txt");
            //先将数组转为字符串，然后将里面的数据替换
            String str = Arrays.toString(arr).replace(", ", "-");
            //提取字符串
            String result = str.substring(1, str.length() - 1);
            //写入文件
            fw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
