package com.lanqiao.javalearn.java2.test7.challenge;

import java.lang.annotation.*;

/**
 * 自定义注解
 */

// 补充注解代码
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTag {
    // 补充代码
    String name() default "车";

    int size() default 10;
}
