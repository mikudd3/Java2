package com.lanqiao.javalearn.java2.test7.myannotation.task;

import java.lang.annotation.*;

/**
 * @project: 自定义苹果颜色注解
 * @author: mikudd3
 * @version: 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor {
    String fruitColor() default "";

}


