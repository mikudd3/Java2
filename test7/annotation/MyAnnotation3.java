package com.lanqiao.javalearn.java2.test7.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @project: @Retention 注解的使用
 * @author: mikudd3
 * @version: 1.0
 */
// 可以在不同的成员上加注解，多个是需要加上{}，用逗号分隔。
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD,
        ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
//当运行 Java 程序时，虚拟机保留注解
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation3 {
    // 定义两个属性 name 和 age，带上默认值
    String name() default "mikudd3";

    int age() default 20;
}
