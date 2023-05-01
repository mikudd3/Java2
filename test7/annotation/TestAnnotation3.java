package com.lanqiao.javalearn.java2.test7.annotation;

public class TestAnnotation3 {
    @MyAnnotation3(name = "Rose", age = 10)
    private String info;

    @MyAnnotation3
    public void getObjectInfo() {

    }
}
