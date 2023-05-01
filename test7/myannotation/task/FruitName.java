package com.lanqiao.javalearn.java2.test7.myannotation.task;

import java.lang.annotation.*;

/**
 * @project: 苹果自定义注解
 * @author: mikudd3
 * @version: 1.0
 */
@Documented//记录
@Target(ElementType.FIELD)//目标 元素类型字段 这个注解 可以定义在 属性（变量）上 何地
@Retention(RetentionPolicy.RUNTIME)//保留 保留策略运行时
public @interface FruitName {
    String value() default "";
}


