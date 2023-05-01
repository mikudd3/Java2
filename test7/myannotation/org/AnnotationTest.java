package com.lanqiao.javalearn.java2.test7.myannotation.org;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */

public class AnnotationTest {

    @MyMessage(num = 10, desc = "参数a")
    private static int a;


    @MyMessage(name = "Sam test", desc = "测试方法test")
    public void test() {
        System.out.println("test");
    }

}
