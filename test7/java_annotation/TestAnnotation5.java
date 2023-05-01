package com.lanqiao.javalearn.java2.test7.java_annotation;

/**
 * @project: 内建注解的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestAnnotation5 {
    public static void main(String[] args) {
        Student s = new Student();
        s.getInfo();
        s.running();
    }
}

class Person {
    public void getInfo() {

    }
}

class Student extends Person {
    @Override
    public void getInfo() {
        super.getInfo();
    }

    // 过时方法的标识
    @Deprecated
    public void running() {
        System.out.println("跑步锻炼中");
    }
}
