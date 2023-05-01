package com.lanqiao.javalearn.java2.test7.annotation;

/**
 * @project: 自定义注解
 * @author: mikudd3
 * @version: 1.0
 */
public @interface MyAnnotation {
    // 定义两个属性 name 和 age，带上默认值
    String name() default "mikudd3";

    int age() default 20;
}
