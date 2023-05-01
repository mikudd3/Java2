package com.lanqiao.javalearn.java2.test7.annotation;

/**
 * @project: 自定义注解 测试
 * @author: mikudd3
 * @version: 1.0
 */
public class TestAnnotation {
    @MyAnnotation(name = "Tom", age = 20)
    public void getObjectInfo() {

    }

    // name 和 age 使用默认值
    @MyAnnotation()
    public void getDefaultInfo() {

    }
}
