package com.lanqiao.javalearn.java2.test9.lambda;

import java.util.function.Function;

/**
 * @project: 更简化的 Lambda 表达式的书写
 * @author: mikudd3
 * @version: 1.0
 */
public class TestLambda4 {
    public static void main(String[] args) {
        // Lambda表达式
        Function<String, Integer> func = (String arg) -> {
            return Integer.parseInt(arg);
        };
        System.out.println(func.apply("100"));

        // 省略了输入参数的类型
        Function<String, Integer> func1 = (arg) -> {
            return Integer.parseInt(arg);
        };
        System.out.println(func.apply("200"));

        // 省略了输入参数类型、return关键字和{}
        // 省略了输入参数的类型
        Function<String, Integer> func3 = (arg) -> Integer.parseInt(arg);
        System.out.println(func.apply("300"));
    }
}
