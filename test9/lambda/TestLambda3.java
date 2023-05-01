package com.lanqiao.javalearn.java2.test9.lambda;

import java.util.function.Supplier;

/**
 * @project: Supplier 函数式接口使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestLambda3 {
    public static void main(String[] args) {
        Supplier<Double> rand = () -> {
            return Math.random();
        };
        System.out.println(rand.get());
    }
}
