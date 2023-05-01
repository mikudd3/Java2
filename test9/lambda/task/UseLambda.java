package com.lanqiao.javalearn.java2.test9.lambda.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @project: 使用 Lambda 表达式对数据进行操作
 * @author: mikudd3
 * @version: 1.0
 */
public class UseLambda {
    public static void main(String[] args) {
        Integer[] arr = {76, 1, 55, 17, 23, 99};
        Arrays.sort(arr, (a, b) -> b - a);
        Arrays.asList(arr).forEach(num-> System.out.println(num));


        String[] str = {"天地玄黄", "宇宙洪荒", "日月盈昃", "辰宿列张", "寒来暑往", "秋收冬藏"};
        Arrays.asList(str).forEach(System.out::println);


    }
}
