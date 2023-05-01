package com.lanqiao.javalearn.java2.test9.methodref;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @project: 采用方法引用方式对数据进行操作
 * @author: mikudd3
 * @version: 1.0
 */
public class UseMethodRef {
    public static void main(String[] args) {

        // 程序代码
        Integer[] arr = {76, 1, 55, 17, 23, 99};
        Arrays.sort(arr, (a, b) -> b - a);
        Arrays.asList(arr).forEach(System.out::println);


        String[] str = {"天地玄黄", "宇宙洪荒", "日月盈昃", "辰宿列张", "寒来暑往", "秋收冬藏"};
        Arrays.asList(str).forEach(System.out::println);

        //引用集合
        INames iNames = ArrayList::new;
        ArrayList<String> list = iNames.storeNames();
        list.add("张三");
        list.add("李四");
        list.add("小桃子");
        list.forEach(System.out::println);


    }
}

interface INames {
    ArrayList<String> storeNames();
}
