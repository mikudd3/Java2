package com.lanqiao.javalearn.java2.test9.lambda.main;

import java.util.ArrayList;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class TestLambda {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        //加入集合
        names.add("mikudd3");
        names.add("mikudd3");
        names.add("mikudd3");
        names.add("mikudd3");

        //使用lambda表达式打印输出
        names.forEach((name) -> System.out.println(name));
    }
}
