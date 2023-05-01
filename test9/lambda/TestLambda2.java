package com.lanqiao.javalearn.java2.test9.lambda;

/**
 * @project: 使用自定义函数式接口
 * @author: mikudd3
 * @version: 1.0
 */
public class TestLambda2 {
    public TestLambda2(MyLambda myLambda) {
        myLambda.method();
    }

    public static void main(String[] args) {
        new TestLambda2(() -> System.out.println("Hello World"));
    }
}

//自定义的函数式接口
interface MyLambda {
    void method();
}
