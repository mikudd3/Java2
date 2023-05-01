package com.lanqiao.javalearn.java2.test9.lambda;

/**
 * @project: Lambda 表达式简化代码
 * @author: mikudd3
 * @version: 1.0
 */
public class TestLambda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello World")).start();
    }
}
