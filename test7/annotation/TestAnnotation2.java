package com.lanqiao.javalearn.java2.test7.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @project: @Target 元注解的使用
 * @author: mikudd3
 * @version: 1.0
 */

//限制此注解只能使用在属性上
@Target(ElementType.FIELD)
@interface MyAnnotation2 {
    String name() default "mikudd3";

    int age() default 20;
}

public class TestAnnotation2 {
    //在方法上使用自定义注解
    @MyAnnotation
    public void getObjectInfo() {

    }
}
