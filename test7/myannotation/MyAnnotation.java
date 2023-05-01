package com.lanqiao.javalearn.java2.test7.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @project: 自定义注解
 * @author: mikudd3
 * @version: 1.0
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value();

    //定义两个属性 name 和 age，带上默认值
    String name() default "mikudd3";

    int age() default 18;
}